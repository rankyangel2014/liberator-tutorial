(ns liberator-tutorial.core
  (:require [liberator.core :refer [resource defresource]]
            [ring.middleware.params :refer [wrap-params]]
            [compojure.core :refer [defroutes ANY GET POST]]))

(defroutes app
           (GET "/foo/:txt" [txt] (resource :available-media-types ["text/html"]
                                            :handle-ok (str "<html>Hello, Internet.</html>" txt))))

(def handler
  (-> app
      wrap-params))