(ns leiningen.magic
  (:require [enchant.repl :as mrepl]
            [clojure.tools.nrepl :as nrepl]
            [reply.eval-modes.nrepl]
            [reply.eval-modes.shared]
            [leiningen.repl :as lrepl]))

(defn magic
  "Launch a Magic REPL."
  [project & more]
  ;; (println (:repl-options project))
  (let [roptions (:repl-options project)
        port (or (:port roptions) 0)
        server (mrepl/start-server (assoc roptions :port port))
        port (:port server) ;; get port from started server
;; experimental code: use reply directly? But difficult to startup
;        connection (reply.eval-modes.nrepl/get-connection 
;                     ;; we want to attach to existing server 
;                     {:attach (str "nrepl://" "localhost" ":" port)})  
;                      
;        client (nrepl/client connection Long/MAX_VALUE)
;        options (merge 
;                  (reply.eval-modes.shared/set-default-options roptions)
;                  {:port (str port)})
        ]
    ;; start the magic repl server
    ;; (reply.eval-modes.nrepl/run-repl client options)
    (lrepl/repl project ":connect" (str "localhost:" port)) ;; connect with lein repl
    ;; (alter-var-root #'enchant.repl/magic? (constantly true))              
    ))