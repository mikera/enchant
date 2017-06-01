(ns leiningen.magic
  (:require [magic.repl :as mrepl]
            [leiningen.repl :as lrepl]))

(defn magic
  "Launch a Magic REPL."
  [project & more]
  ;; (println (:repl-options project))
  (let [roptions (:repl-options project)
        port (:port roptions)]
    (mrepl/start-server roptions)              ;; start the magic repl server
    (lrepl/repl project ":connect" (str "localhost:" port)) ;; connect with lein repl
    ))