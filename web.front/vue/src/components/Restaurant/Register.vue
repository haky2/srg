<template>
  <div>
    <button @click="getData">Get data</button>
    <h1>맛집 등록</h1>
      <form id="saveForm" name="saveForm">
    <table>
        <tr>
            <th>상호명</th>
            <td><input type="text" name="rstName" id="rstName" placeholder="상호명을 입력해주세요." /></td>
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
            <th>소개</th>
            <td>
                <textarea id="rstDesc" name="rstDesc" rows="7" style="width:100%;" placeholder="가게를 소개해주세요."></textarea>
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
  name: 'RestaurantRegister',
  data() {
    return {
        categories : {},
        modalData : {
            title : 'test'
        },
    };

  },
  methods: {
    getData () {

    },
    saveData() {
        var form = document.getElementById('saveForm');
        var formData = new FormData(form);
        axios({
            method : 'post',
            url:'/api/restaurant/save',
            headers : {'Content-Type' : 'application/json'},
            data : formData
            })
            .then(function(res){
                if (res.data == "success") {
                    alert("신규 맛집을 추가했습니다.");
                } else {
                    alert(res.data);
                }
            }).catch(function(error){
                if (error.response) {
                    alert(error.response.data);
                } else if (error.request) {
                    alert(error.request);
                } else {
                    alert(error.message);
                }
                return false;
            });
        }
  },
  mounted() {
      axios
          .get('/api/restaurant/categories')
          .then(res => {
              this.categories = res.data;
          });

      this.modalData.title = "";
  }
}

</script>
