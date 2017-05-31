(ns magic.main
  (:use [clojure.repl])
  (:require [clojure.tools.nrepl :as repl]
            [clojure.tools.nrepl.server :as server]
            [clojure.tools.nrepl.middleware :as middleware]
            [clojure.tools.nrepl.middleware.interruptible-eval]
            [clojure.tools.nrepl.transport :as transport]
            [clojure.tools.nrepl.misc :as nrepl-misc]))

(defn magic-eval
  [{:keys [op code session transport] :as msg}]
  (println "Code = " code)
  (let [val (str (System/currentTimeMillis))
        resp (nrepl-misc/response-for msg 
                                      :status :done
                                      :printed-value 1
                                      :value val
                                      :out val)]
    (println "Resp = " resp)
    (transport/send transport resp)))


(defn magic-handler
  "nREPL middleware function for Magic operations"
  [h]
  (fn [{:keys [op session transport] :as msg}]
    (cond
      (= "eval" op)
        (#'magic-eval msg)
      :else
        (h msg))))

(middleware/set-descriptor! #'magic-handler
  {:requires #{"clone"}
   :expects #{"eval"}
;   :handles {"eval"
;             {:doc "Evaluates code."
;              :requires {"code" "The code to be evaluated, as a String."
;                         "session" "The ID of the session within which to evaluate the code."}
;              :optional {"id" "An opaque message ID that will be included in responses related to the evaluation, and which may be used to restrict the scope of a later \"interrupt\" operation."}
;              :returns {"ns" "*ns*, after successful evaluation of `code`."
;                        "values" "The result of evaluating `code`, often `read`able. This printing is provided by the `pr-values` middleware, and could theoretically be customized. Superseded by `ex` and `root-ex` if an exception occurs during evaluation."
;                        "ex" "The type of exception thrown, if any. If present, then `values` will be absent."
;                        "root-ex" "The type of the root exception thrown, if any. If present, then `values` will be absent."}
;              }}
   :handles {}
   })

(def magic-nrepl-handler
  (server/default-handler #'magic-handler))

(middleware/set-descriptor! #'magic-nrepl-handler
  {:requires #{"clone"}
   :expects #{"eval"}
   :handles {}
   })

(comment 
  (server/default-handler #'magic-handler)
  
  (server/start-server :handler (server/default-handler #'magic-handler))
  (server/start-server :handler (server/default-handler #'magic-handler))
  )