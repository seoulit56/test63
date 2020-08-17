<template>
    <div class="h-100 bg-premium-dark">
      <div class="d-flex h-100 justify-content-center align-items-center">
        <b-col md="8" class="mx-auto app-login-box">
          <div class="app-logo-inverse mx-auto mb-3"/>
          <div class="main-card mb-3 card">
            <div class="card-body"><h5 class="card-title">회원 가입</h5>
              <form class="">
                <div class="form-row">
                  <div class="col-md-4 ws-15">
                    <md-field>
                      <label>Search..</label>
                      <md-input></md-input>
                    </md-field>
                  </div>
                  <div class="col-md-4 ws-15">
                    <md-field :class="messageClass">
                      <label>이름</label>
                      <md-input v-model="required" required></md-input>
                      <span class="md-error">There is an error</span>
                      <i class="icon-font icon-font-at" style="padding-top: 15px;"></i>
                    </md-field>
                  </div>
                   <div class="col-md-4 ws-15">
                     <md-field>
                       <label>이메일</label>
                       <md-input required></md-input>
                       <span class="md-suffix"><i class="icon-font icon-font-phone"> </i></span>
                     </md-field>
                  </div>
                </div>
                <div class="position-relative form-group"><label for="exampleAddress" class="">Address</label><input name="address" id="exampleAddress" placeholder="1234 Main St" type="text" class="form-control"></div>
                <div class="position-relative form-group"><label for="exampleAddress2" class="">Address 2</label><input name="address2" id="exampleAddress2" placeholder="Apartment, studio, or floor" type="text" class="form-control"></div>
                <div class="form-row">
                  <div class="col-md-6">
                    <div class="position-relative form-group"><label for="exampleCity" class="">City</label><input name="city" id="exampleCity" type="text" class="form-control"></div>
                  </div>
                  <div class="col-md-4">
                    <div class="position-relative form-group"><label for="exampleState" class="">State</label><input name="state" id="exampleState" type="text" class="form-control"></div>
                  </div>
                  <div class="col-md-2">
                    <div class="position-relative form-group"><label for="exampleZip" class="">Zip</label><input name="zip" id="exampleZip" type="text" class="form-control"></div>
                  </div>
                </div>
                <div class="position-relative form-check"><input name="check" id="exampleCheck" type="checkbox" class="form-check-input"><label for="exampleCheck" class="form-check-label">Check me out</label></div>
                <button class="mt-2 btn btn-primary">Sign in</button>
              </form>
            </div>
          </div>
                </b-col>
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
