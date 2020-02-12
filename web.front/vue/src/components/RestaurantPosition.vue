<template>
    <div id="RestaurantPosition" v-bind:style="style">
    </div>
</template>
<script>
    export default {
        name: "RestaurantPosition",
        props: {
            latitude: {
                type: String,
                default: '33.450701'
            },
            longitude: {
                type: String,
                default: '126.570667'
            }
        },
        data() {
            return {
                style: {
                    height: '300px',
                    marginBottom: '32px'
                }
            }
        },
        methods: {
            init: function () {
                let el = document.createElement('script'), self = this;
                el.setAttribute('type', 'text/javascript');
                el.setAttribute('src', '//dapi.kakao.com/v2/maps/sdk.js?appkey=611c765227d22d5c306b090de93d4812&autoload=false');
                document.getElementsByTagName('head')[0].appendChild(el);
                // onload에 init 메소드 지정
                el.onload = function () {
                    kakao.maps.load(function () {
                        var mapContainer = document.getElementById('RestaurantPosition'), // 지도를 표시할 div
                            mapOption = {
                                center: new kakao.maps.LatLng(self.latitude, self.longitude), // 지도의 중심좌표
                                level: 3 // 지도의 확대 레벨
                            };
                        var map = new kakao.maps.Map(mapContainer, mapOption);
                    });
                };
            }
        },
        created() {
        },
        mounted() {
            this.init();
        }
    }
</script>

<style scoped>

</style>