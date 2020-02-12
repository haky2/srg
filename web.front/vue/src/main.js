import Vue from 'vue'
import VueRouter from 'vue-router'
import App from "./App";
import HelloWorld from "./components/HelloWorld";
import Restaurant from "./components/Restaurant";
import Join from "./components/Join";
import RestaurantPosition from "./components/RestaurantPosition";

Vue.use(VueRouter)

const routes = [
  { path: '/', component: HelloWorld },
  { path: '/restaurant', component: Restaurant },
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
