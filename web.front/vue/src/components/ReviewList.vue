<template>
    <div>
        <h2>{{title}}</h2>
        <ol>
            <li v-for="(review, idx) in reviews" v-bind:key="review + idx">
                <router-link :to="{name: 'reviewbyno', params: {no: review.reviewNo}}">{{review.title}}</router-link>
            </li>
        </ol>
    </div>
</template>

<script>
  const axios = require('axios');
  export default {
    name: "ReviewList.vue",
    data () {
      return {
        title: '리뷰 리스트',
        reviews: {
          title: ''
        },
        reviewLink: '/reviews/'
      }
    },
    mounted() {
      axios
        .get('/api/reviews')
        .then(res => {
          // eslint-disable-next-line no-console
          console.log(res.data);
          this.reviews = res.data;
        })
    }
  }
</script>
<style scoped>
    ul {
        padding: 0;
    }
    li {
        margin: 0 10px;
    }
</style>