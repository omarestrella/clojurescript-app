(ns app.core
    (:require [rum.core :as rum]
              [bide.core :as bide]
              [app.router :as router]
              [app.navigation :as navigation]
              [app.components.index :as index]
              [app.components.test :as test]))

(enable-console-print!)

(defonce components {:index index/component
                     :test test/component})

(defn component-for [route]
  (get components route))

(defn mount [name]
  (rum/mount ((component-for name))
             (. js/document (getElementById "app"))))

(defn on-navigate
  [name params query]
  (mount name))

(router/init on-navigate)

(rum/mount (navigation/component)
           (. js/document (getElementById "nav")))

(defn on-js-reload [])

