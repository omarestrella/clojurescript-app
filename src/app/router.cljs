(ns app.router
  (:require [bide.core :as bide]))

(defonce current-route (atom {}))
(defonce router
  (bide/router [["/" :index]
                ["/test" :test]]))

(defn on-navigate [name params query]
  (println "Route changed to: " name params query)
  (swap! current-route assoc
         :name name
         :params params
         :query query))

(defn init [handler]
  (bide/start! router {:default :index
                       :on-navigate (fn [& args]
                                      (apply on-navigate args)
                                      (apply handler args))}))
