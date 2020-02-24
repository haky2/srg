<template>
    <div>
        <h2>{{title}}</h2>
        <div>
            <h3>제목 : {{reviewItem.title}}</h3>
            <h4>별점 : {{reviewItem.score}}</h4>
            <p>작성일 : {{reviewItem.writtenYmdt}} | 수정일 : {{reviewItem.updatedYmdt}}</p>
            <p>{{reviewItem.content}}</p>
        </div>
    </div>
</template>

<script>
  const axios = require('axios');
  export default {
    name: "ReviewItem.vue",
    props: ['no'],
  data () {
    return {
      title: '리뷰 상세',
      reviewItem: {
        title: '',
        score: 0,
        content: '',
        writtenYmdt: '',
        updatedYmdt: ''
      }
    }
  },
    mounted() {
      axios
        .get('/api/reviews/'+this.no)
        .then(res => {
          // eslint-disable-next-line no-console
          console.log(res.data);
          this.reviewItem = res.data;
        })
    }
  }
</script>

<style scoped>

</style>