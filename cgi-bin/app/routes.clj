(ns app.routes
  (:require
   [app.test-route :as t]))

(def routes 
  [{:path "/wurst"
    :method :get
    :response {:status 200
               :body t/test-route}}])
