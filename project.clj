(defproject confuse "0.0.1-SNAPSHOT"
  :description "Magic Integration for Clojure"
  :url "https://github.com/mikera/magic-clojure"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  
  :source-paths ["src/main/clj"]
  :test-paths ["src/test/clj"]
  
  :resource-paths ["resources"]
  
  :main magic.main
  
  
  :dependencies [[org.clojure/clojure "1.9.0-alpha15"]
                 [com.rpl/specter "1.0.1"]
                 [net.mikera/magic "0.0.1-SNAPSHOT"] ]
  :profiles  {:dev  {:dependencies  [[org.clojure/test.check "0.9.0"]]}
              :test {:dependencies  []}
              }
  )