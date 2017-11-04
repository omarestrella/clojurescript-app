(ns app.components.link-to
  (:require [bide.core :as bide]
            [app.router :refer [router]]))

(defn link-to [route text]
  [:a {:href (str "/#" (bide/resolve router route))}
   text])