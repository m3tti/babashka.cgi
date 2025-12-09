(ns app.routes
  (:require
   [app.test-route :as t]))

(defn route []
  (t/test-route))
