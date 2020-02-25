import Vue from 'vue'
import VueRouter from 'vue-router'
import App from "./App"
import axios from "axios"
import HelloWorld from "./components/HelloWorld";
import Restaurant from "./components/Restaurant/List";
import RestaurantRegister from "./components/Restaurant/Register"
import Join from "./components/Join";
import RestaurantPosition from "./components/RestaurantPosition";

Vue.use(VueRouter)
Vue.prototype.$axios = axios;

const routes = [
  { path: '/', component: HelloWorld },
  { path: '/restaurant/list', component: Restaurant },
  { path: '/restaurant/register', component: RestaurantRegister },
  { path: '/join', component: Join },
  { path: '/restaurant_position', component: RestaurantPosition  }
]

const router = new VueRouter({
  routes,
  mode: "history"
})


new Vue({
  render: h => h(App),
  router
}).$mount('#app')
