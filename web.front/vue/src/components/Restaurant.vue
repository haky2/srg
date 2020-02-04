<template>
  <div>
    <button @click="getData">Get data</button>
    <h1>Restaurant Info!</h1>
    <ul style="width:400px; margin:0 auto; text-align:left;">
        <li class="id">{{ id }}</li>
        <li class="name">{{ name }}</li>
        <li class="address">{{ address }}</li>
    </ul>
  </div>
</template>
<script>
export default {
  name: 'Restaurant',
  data() {
    return {
        address : null,
        id : null,
        name : null
    };
  },
  methods: {
    getData () {
        axios
            .get('/api/restaurant/123')
            .then(res => {
                this.id = "Restaurant id : " + res.data.response.id;
                this.name = "name : " + res.data.response.name;
                this.address = "address : " + res.data.response.address;

            })
    }
  },
  mounted() {
  }
}
</script>
