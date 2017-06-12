(ns leiningen.magic
  (:require [enchant.repl :as mrepl]
            [leiningen.repl :as lrepl]))

(defn magic
  "Launch a Magic REPL."
  [project & more]
  ;; (println (:repl-options project))
  (let [roptions (:repl-options project)
        port (or (:port roptions) 0)
        server (mrepl/start-server (assoc roptions :port port))
        port (:port server)]
                  ;; start the magic repl server
    (lrepl/repl project ":connect" (str "localhost:" port)) ;; connect with lein repl
    ))