<template>
  <div>
    <button @click="getData">Get data</button>
    <h1>맛집 등록</h1>
      <form id="saveForm" name="saveForm">
    <table>
        <tr>
            <th>가게 이름</th>
            <td><input type="text" name="rstName" id="rstName" placeholder="가게 이름을 입력해주세요." /></td>
        </tr>
        <tr>
            <th>주소</th>
            <td>
                <button>주소 검색</button>
            </td>
        </tr>
        <tr>
            <th>영업시간</th>
            <td><input type="text" name="storeHour" id="storeHour" placeholder="영업 시간을 입력해주세요." /></td>
        </tr>
        <tr>
            <th>음식 종류</th>
            <td>
                <select id="rstCategory" name="rstCategory">
                    <option v-for="(key, value) in categories" v-bind:key="key" v-bind:value="value">
                        {{ key }}
                    </option>
                </select>
            </td>
        </tr>
        <tr>
            <th>메뉴</th>
            <td>
                <textarea name="rstMenu" rows="7" style="width:100%;" placeholder=""></textarea>
            </td>
        </tr>
        <tr>
            <th>검색 태그</th>
            <td>
                <input type="text" name="rstTag" placeholder="ex) #중국집#짬뽕맛집"/>
            </td>
        </tr>
        <tr>
            <th>가게 소개</th>
            <td>
                <textarea rows="7" style="width:100%;" placeholder="가게를 소개해주세요."></textarea>
            </td>
        </tr>
    </table>
      <div><input @click="saveData" type="button" value="저장" /></div>
      </form>
  </div>
</template>
<script>
const axios = require('axios');
export default {
  name: 'Restaurant',
  data() {
    return {
        categories : []
    };

  },
  methods: {
    getData () {
    },
    saveData() {
        var form = document.getElementById('saveForm');
        var formData = new FormData(form);
        axios
            .post('/api/restaurant/save', formData)
            .then(function(res){
                if (res.data == "success") {
                    alert("신규 맛집을 추가했습니다.");
                } else {
                    alert(res.data);
                }
            });
    }
  },
  mounted() {
      axios
          .get('/api/restaurant/categoryList')
          .then(res => {
              this.categories = res.data;
          });
  }
}
</script>
