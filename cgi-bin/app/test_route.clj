(ns app.test-route
  (:require
   [app.request :as req]
   [app.response :as res]
   [cheshire.core :as json]))

(defn test-route [req]
  [:ul
   [:li (str req)]
   [:li (str (req/query-params))]
   [:li (req/server-url)]
   [:li (json/encode (System/getenv))]])
