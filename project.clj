(defproject biva-clojure-test "0.1.0-SNAPSHOT"
  :description "REST service for documents"
  :url "http://github.com/riosgabriel"
  :main bivatest.main
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [compojure "1.1.1"]
                 [ring/ring-json "0.1.2"]
                 [c3p0/c3p0 "0.9.1.2"]
                 [org.clojure/java.jdbc "0.2.3"]
                 [com.h2database/h2 "1.3.168"]
                 [cheshire "4.0.3"]
                 [com.datomic/datomic-free "0.9.5350"]]

  :plugins [[lein-ring "0.7.3"]
            [lein-datomic "0.2.0"]]
  :ring {:handler bivatest.apiHandler/app}
  :profiles {:dev
             {:datomic {:config "resources/transactor.properties"
                        :db-uri "datomic:free://localhost:4334/biva-db"
                        :install-location "/home/gabriel/datomic/datomic-free-0.9.5350"}}}
  :datomic {:schemas ["resources" ["schema.edn"]]}
)