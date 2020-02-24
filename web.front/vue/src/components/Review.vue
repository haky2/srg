<template>
    <div id="reviews">
        <h1>다녀온 맛집 리뷰를 공유해요!</h1>
        <router-view></router-view>
    </div>
</template>

<script>

export default {
  props: ['no']
}
</script>

<style>
    a {
        color: #42b983;
    }
</style>