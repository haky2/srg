<template>
    <div class="wrap" v-bind:style="listStyle">
        <h1>맛집 리스트</h1>
        <div v-bind:style="linkAlign"><a href="/restaurant/register" v-bind:style="linkStyle">신규 등록</a></div>
        <table v-bind:style="tableStyle">
            <thead>
            <tr>
                <th>No.</th>
                <th width="50%">상호명</th>
                <th>분류</th>
                <th>영업시간</th>
                <th>등록일</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="(data, key) in list" v-bind:key="key" v-bind:value="data">
                <td>{{ data.rstNo }}</td>
                <td v-bind:style="textLeft">{{ data.rstName }}</td>
                <td>{{ categories[data.rstCategory] }}</td>
                <td>{{ data.storeHour }}</td>
                <td>{{ data.regYmdt }}</td>
            </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
    const axios = require('axios');
    export default {
        name: 'Restaurant',
        data() {
            return {
                categories : {},
                list : {},
                linkAlign : {
                    float: 'right'
                },
                textLeft : {
                    textAlign : 'left'
                },
                tableStyle : {
                    margin : '0 auto',
                    textAlign : 'center',
                    width : '100%'
                },
                linkStyle : {
                    font : '400 14px system-ui',
                    float : 'right',
                    padding : '5px 14px',
                    textDecoration : 'none',
                    borderRadius : '4px',
                    color : 'rgba(255, 255, 255, 0.85)',
                    boxShadow: 'rgba(30, 22, 54, 0.7) 0 80px 0px 2px inset'
                },
                listStyle : {
                    width : '80%',
                    margin : '0 auto',
                }
            };

        },
        methods: {
            getList() {
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

            axios({
                method : 'get',
                url:'/api/restaurant/list',
                headers : {'Content-Type' : 'application/json'},
                data : {}
            }).then(res => {
                this.list = res.data;
            });
        }
    }

</script>
