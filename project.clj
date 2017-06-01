(defproject magic-clojure "0.0.1-SNAPSHOT"
  :description "Magic Integration for Clojure"
  :url "https://github.com/mikera/magic-clojure"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  
  :source-paths ["src/main/clj"]
  :test-paths ["src/test/clj"]
  
  :resource-paths ["resources"]
  
  :main magic.main
  
  :eval-in-leiningen true
  
  :dependencies [[org.clojure/tools.nrepl "0.2.12"]
                 [org.clojure/clojure "1.9.0-alpha15"]
                 [com.rpl/specter "1.0.1"]
                 [net.mikera/magic "0.0.1-SNAPSHOT"] ]
  :profiles  {:dev  {:dependencies  [[org.clojure/test.check "0.9.0"]]
                     :repl-options {:nrepl-middleware [magic.repl/magic-handler]
                                    :host "0.0.0.0"
                                    :port 4001}}
              :test {:dependencies  []}
              }
  )