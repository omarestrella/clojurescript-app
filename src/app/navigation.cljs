(ns app.navigation
  (:require [rum.core :as rum]
            [app.components.link-to :refer [link-to]]))

(rum/defc component []
  [:div
   (link-to :index "Index")
   [:br]
   (link-to :test "Test")])
