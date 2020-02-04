import Vue from 'vue'
import VueRouter from 'vue-router'
import App from "./App";
import HelloWorld from "./components/HelloWorld";
import Restaurant from "./components/Restaurant";
import join from "./components/join";

Vue.use(VueRouter)

const routes = [
  { path: '/', component: HelloWorld },
  { path: '/restaurant', component: Restaurant },
  { path: '/join', component: join }
]

const router = new VueRouter({
  routes,
  mode: "history"
})


new Vue({
  render: h => h(App),
  router
}).$mount('#app')
