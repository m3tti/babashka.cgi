(ns app.test
  (:require
   [app.request :as req]
   [app.response :as res]
   [cheshire.core :as json]))

(defn test-route []
  (res/render
   [:ul
    [:li (str (req/query-params))]
    [:li (req/server-url)]
    [:li (json/encode (System/getenv))]]))
