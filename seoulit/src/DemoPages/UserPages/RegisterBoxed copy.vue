<template>

    <div class="content">
              <div class ="ee">
              <div>
                asasasasa
                </div>
          <div class="main-card mb-3 card">
            <div class="card-body"><h5 class="card-title">회원 가입</h5>
              <form class="">
                <div class="form-row">
                  <div class="col-md-3 ws-15">
                    <md-field>
                      <label>아이디</label>
                      <md-input></md-input>
                       <i class="icon-font icon-font-id-card" style="padding-top: 15px;"></i>
                    </md-field>
                  </div>
                  <div class="col-md-3 ws-15">
                    <md-field :class="messageClass">
                      <label>이름</label>
                      <md-input v-model="required" required></md-input>
                      <span class="md-error">There is an error</span>
                      <i class="icon-font icon-font-at" style="padding-top: 15px;"></i>
                    </md-field>
                  </div>
                   <div class="col-md-3 ws-15">
                     <md-field>
                       <label>패스워드</label>
                       <md-input required></md-input>
                       <span class="md-suffix"><i class="icon-font icon-font-phone"> </i></span>
                     </md-field>
                  </div>
                   <div class="col-md-3 ws-15">
                     <md-field>
                       <label>패드워드 확인</label>
                       <md-input required></md-input>
                       <span class="md-suffix"><i class="icon-font icon-font-phone"> </i></span>
                     </md-field>
                  </div>
                </div>
                <div class="form-row">
                  <div class="col-md-3 ws-15">
                    <md-field>
                      <label>아이디</label>
                      <md-input></md-input>
                       <i class="icon-font icon-font-id-card" style="padding-top: 15px;"></i>
                    </md-field>
                  </div>
                  <div class="col-md-3 ws-15">
                    <md-field :class="messageClass">
                      <label>이름</label>
                      <md-input v-model="required" required></md-input>
                      <span class="md-error">There is an error</span>
                      <i class="icon-font icon-font-at" style="padding-top: 15px;"></i>
                    </md-field>
                  </div>
                   <div class="col-md-3 ws-15">
                     <md-field>
                       <label>패스워드</label>
                       <md-input required></md-input>
                       <span class="md-suffix"><i class="icon-font icon-font-phone"> </i></span>
                     </md-field>
                  </div>
                   <div class="col-md-3 ws-15">
                     <md-field>
                       <label>패드워드 확인</label>
                       <md-input required></md-input>
                       <span class="md-suffix"><i class="icon-font icon-font-phone"> </i></span>
                     </md-field>
                  </div>
                </div>
                <div class="position-relative form-check"><input name="check" id="exampleCheck" type="checkbox" class="form-check-input"><label for="exampleCheck" class="form-check-label">Check me out</label></div>
                <button class="mt-2 btn btn-primary">Sign in</button>
              </form>
            </div>
          </div>
              </div>
  </div>
</template>

<script>
export default {
    name: 'ErrorsMessages',
    data: () => ({
      noError: null,
      required: null,
      textarea: null,
      hasMessages: false
    }),
    computed: {
      messageClass () {
        return {
          'md-invalid': this.hasMessages
        }
      }
    }
}
</script>
