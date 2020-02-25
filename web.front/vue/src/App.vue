<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png">
    <router-link to="/">Home   </router-link>
    <router-link to="/join">회원가입   </router-link>
    <router-link to="/restaurant/list">맛집   </router-link>
    <router-link to="/restaurant_position">맛집 지도   </router-link>
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: 'app',
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
