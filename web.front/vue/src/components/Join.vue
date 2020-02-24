<template>
    <div class="wrap">
        <div class="login-wrap">
            <div class="enter" id="enter">
                <h1>회원가입</h1>
                <div class="join-form" id="" style="">
                    <h5>회원정보 입력</h5>
                    <div class="join-infor-text">
                        * 필수 입력 사항
                    </div>
                    <dl>
                        <dt><em class="must">* </em>아이디</dt>
                        <dd>
                            <input v-model="userId" class="input-large" type="email" id="userId" name="userId" value="" placeholder="아이디(이메일) 입력">
                        </dd>
                    </dl>
                    <dl>
                        <dt><em class="must">* </em>비밀번호</dt>
                        <dd>
                            <input v-model="password" class="input-large" type="password" id="password" name="password" placeholder="영문/숫자/특수문자 조합하여 8~20자 입력" maxlength="20">
                        </dd>
                    </dl>
                    <dl>
                        <dt><em class="must">* </em>이메일</dt>
                        <dd>
                            <input v-model="email" class="input-large" type="email" id="email" name="email" value="" placeholder="아이디(이메일) 입력">
                        </dd>
                    </dl>
                    <dl>
                        <dt><em class="must">* </em>이름</dt>
                        <dd>
                            <input v-model="userName" class="input-large" type="text" id="userName" name="userName" value="" placeholder="이름 입력" maxlength="30">
                        </dd>
                    </dl>
                    <dl>
                        <dt><em class="must">* </em>휴대전화</dt>
                        <dd>
                            <input v-model="mobileNo" class="input-large" type="text" id="mobileNo" name="mobileNo" placeholder="___-____-____" maxlength="13" >
                        </dd>
                    </dl>
                    <dl>
                        <dt><em class="must">* </em>주소</dt>
                        <dd>
                            <input v-model="address" class="input-large" type="text" id="address" name="address" placeholder="___-____-____" maxlength="13" >
                        </dd>
                    </dl>
                </div>
                <button @click="join">Join</button>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "join",
        data() {
            return {
                userId: 'dlwoen9',
                password: 'qwert12345',
                email: 'dlwoen9@godo.co.kr',
                userName: '이재두',
                mobileNo: '01012344321',
                address: '서울시 용산구',
                nickname: '두두',
                birthday: '1990/10/27',
                sex: 'M'
            }
        },
        methods: {
            join () {
                var data = {
                    userId: this.userId,
                    password: this.password,
                    email: this.email,
                    userName: this.userName,
                    mobileNo: this.mobileNo,
                    address: this.address,
                    nickname: this.nickname,
                    birthday: this.birthday,
                    sex: this.sex
                }
                this.$axios.post('/api/users', data)
                    .then(res => {
                        // eslint-disable-next-line no-console
                        console.log(res);
                    })

            }
        },
    }

</script>

<style scoped>

</style>