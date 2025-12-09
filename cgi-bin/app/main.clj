(ns app.main
  (:require
   [app.request :as r]
   [app.response :as res]
   [app.routes :as routes]
   [ruuter.core :as ruuter]))

(defn start []
  (let [req (r/build-request)
        response (ruuter/route routes/routes req)]
    (res/render ((:body response) req) response )))
