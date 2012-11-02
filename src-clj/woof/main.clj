(ns woof.main
  (:use
   [woof.routes :only [app]]
   [ring.adapter.jetty :only [run-jetty]]))

(defn -main [port]
  (run-jetty app {:port (Integer. port)}))
