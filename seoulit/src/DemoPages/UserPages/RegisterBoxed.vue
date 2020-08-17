<template>

    <div class="content">
        <div class ="ee">
           <div>
              asasasasawwwwwwwwwwwww
           </div>
          <div class="main-card mb-4 card">
            <div class="card-body"><h5 class="card-title">{{label.signUp}}</h5>
                <div class="form-row">
                  <div class="col-md-3 ws-15">
                    <md-field :class="validCls(validVisible.idVisible)">
                      <label>{{label.id}}</label>
                      <md-input v-model="user.userId" v-on:blur="isValidId" maxlength=12 required></md-input>
                      <i class="icon-font icon-font-account-c acc"></i>
                      <span class="md-error">{{validMsg.idChkMsg}}</span> 
                    </md-field>
                  </div>
                  <div class="col-md-3 ws-15">
                    <md-field :md-toggle-password="false" :class="validCls(validVisible.pwdVisible)">
                      <label>{{label.pwd}}</label>
                      <md-input type="password" v-model="user.password" v-on:blur="isValidPwd" maxlength=15 required></md-input>
                      <span class="md-error">{{validMsg.pwdChkMsg}}</span> 
                      <i class="icon-font icon-font-lock-q acc"></i>
                    </md-field>
                  </div>
                   <div class="col-md-3 ws-15">
                     <md-field :md-toggle-password="false" :class="validCls(validVisible.cfmPwdVisible)">
                       <label>{{label.cfmPwd}}</label>
                       <md-input type="password" v-on:blur="isValidCfmPwd" v-model="cfmPwd" maxlength=15 required></md-input>
                       <span class="md-error">{{validMsg.cfmPwdChkMsg}}</span>
                       <i class="icon-font icon-font-lock-c acc"> </i>
                     </md-field>
                  </div>
                  <div class="col-md-3 ws-15">
                    <md-field :class="validCls(validVisible.nameVisible)">
                      <label>{{label.name}}</label>
                      <md-input v-on:blur="isValidName" v-model="user.userName" maxlength=5 required></md-input>
                      <span class="md-error">{{validMsg.nameChkMsg}}</span>
                       <i class="icon-font icon-font-account acc"></i>
                    </md-field>
                  </div>                  
                </div>
                <div class="form-row">
                   <div class="col-md-3 ws-15">
                     <md-field :class="validCls(validVisible.emailVisible)">
                       <label>{{label.email}}</label>
                       <md-input v-on:blur="isValidEmail" v-model="user.email" required></md-input>
                       <span class="md-error">{{validMsg.emailChkMsg}}</span>
                       <i class="icon-font icon-font-at acc"> </i>
                     </md-field>
                  </div>                  
                  <div class="col-md-3 ws-15">
                    <md-field :class="validCls(validVisible.genderVisible)">
                      <label for="gender">{{label.gender}}</label>
                      <md-select v-model="user.gender" required>
                        <md-option :key="gender.key" v-for="gender in genderSel" v-bind:value="gender.key">
                          {{gender.value}}
                        </md-option>
                      </md-select>
                      <span class="md-error">{{validMsg.genderChkMsg}}</span>
                    </md-field>
                  </div>
                   <div class="col-md-3 ws-15">
                     <md-field>
                       <label>{{label.address}}</label>
                       <md-input v-model="user.address"></md-input>
                       <i class="icon-font icon-font-map-marker acc"></i>
                     </md-field>
                  </div>
                  <div class="col-md-3 ws-15">
                    <md-datepicker v-on:blur="isValidBirthday" :class="validCls(validVisible.birthdayVisible)" v-model="user.birthday">
                    <label>{{label.birthday}} *</label>
                    <span class="md-error">{{validMsg.birthdayChkMsg}}</span>
                    </md-datepicker>
                  </div>                  
                </div>                
                <div class="form-row">
                  <div class="col-md-2 ws-15">
                    <md-field :class="validCls(validVisible.telVisible)">
                      <label>{{label.tel}}</label>
                      <md-input v-on:blur="isValidTel" v-model="user.tel" required :disabled='isCcnConfirm'></md-input>
                      <span class="md-error">{{validMsg.telChkMsg}}</span>
                      <i class="icon-font icon-font-phone acc"></i>
                    </md-field>
                  </div>
                  <div class="col-md-1 ws-15" style="margin-top:10px">
                    <button v-on:click="ccnSmsChk" class="mt-2 btn btn-outline-focus" :disabled='isCcnBtnDis'>{{label.ccn}}</button>
                  </div>
                  <div class="col-md-3 ws-15">
                    <md-field :md-counter="false" :class="validCls(validVisible.ccnVisible)">
                      <label>{{label.ccn}}</label>
                      <md-input v-on:blur="isValidCcn" v-model="userCcn" required maxlength="6" :disabled='isUserCcnDis'></md-input>
                      <span v-if="!isCcnDisabled && !isCcnConfirm" class="md-suffix">
                        <Timer :ccnTime='ccnTimer' />
                      </span>
                      <span class="md-error">{{validMsg.ccnChkMsg}}</span>
                    </md-field>
                  </div>                                                    
                  <div v-if='!isCcnDisabled && !isCcnConfirm' class="col-md-3 ws-15" style="margin-top:10px">
                    <button v-on:click="ccnConfirm" class="mt-2 btn btn-outline-focus">{{label.ccnComp}}</button>
                  </div>
                  <div v-else-if="isCcnConfirm" class="col-md-4 ws-15" style="margin-top:15px">
                    <b-form-radio-group  buttons button-variant="outline-focus" size="lg" v-model="user.usertype" :options="usertypeSel"/>
                  </div>
                </div>
                <div class="form-row">
                  <div class="col-md-12 ws-15">
                    <md-field>
                      <label>{{label.aboutMe}}</label>
                      <md-input ref='refComment' v-model='user.comment'></md-input>
                    </md-field>
                  </div>
                </div>
                <div class="c-wrapper">
                  <div style="padding-right:15px" class="c-right">
                    <el-button>{{label.login}}</el-button>
                    <el-button v-on:click="signup" type="primary" >{{label.signUp}}</el-button>
                  </div>
                </div>
            </div>
          </div>
        </div>
  </div>
</template>

<script>
import Timer from '@/view/common/Timer.vue'
import EventBus from '@/util/eventbus' 
export default {
  name: 'SIGNUP',
  components: {
    Timer
  },
  watch: {
    'user.birthday'() {
      this.isValidBirthday()
    },
    'user.gender'() {
      this.isValidGender()
    }    
  },
  computed: {
    isCcnBtnDis() {
      if (!this.isCcnConfirm) return !/^(01[016789]{1}|02|0[3-9]{1}[0-9]{1})-?[0-9]{4}-?[0-9]{4}$/.test(this.user.tel)
      else return true
    },
    isUserCcnDis() {
      if (!this.isCcnConfirm) return this.isCcnDisabled
      else return this.isCcnConfirm
    }
  },  
  data: () => ({
    ccnTimer: (2.5 * 60),
    label: null,
    genderSel: null,
    usertypeSel: [],
    smsCcn: null,
    userCcn: null,
    isCcnDisabled: true,
    isCcnConfirm: false,
    cfmPwd: null,
    user: {
      userId: null,
      userName: null,
      password: null,
      tel: null,
      email: null,
      birthday: null,
      gender: null,
      address: null,
      usertype: 'students',
      comment: null
    },
    validMsg: {
      idChkMsg: '',
      nameChkMsg: '',
      pwdChkMsg: '',
      cfmPwdChkMsg: '',
      telChkMsg: '',
      emailChkMsg: '',   
      ccnChkMsg: ''
    },
    validVisible: {
      idVisible: false,
      nameVisible: false,
      pwdVisible: false,
      cfmPwdVisible: false,
      telVisible: false,
      emailVisible: false,
      birthdayVisible: false,
      genderVisible: false,
      ccnVisible:false
    }      
  }),
  methods: {
    init: function () {
      this.$util.setLabel(this.$options.name).then(data => { this.label = data })
      const domain = {obj: this, selList: [{dataObj: 'genderSel', domainId: 'gender'}]} 
      this.$util.setCombo(domain)

      this.$http.get('/api/system/domain/detailAll', {params: {domainId: 'usertype'}}
      ).then(res => {
        res.data.forEach(row => {
          let obj = {}
          obj.text = row.value
          obj.value = row.key
          if(!row.keyUsing) obj.disabled = true
          this.usertypeSel.push(obj)
        })
        
      }).catch(error => {
        console.log(error)
      })  
    },
    validCls: function (param) {
      return {
        'md-invalid': param
      }
    },
    isValidId: function (e) {
      const util = this.$util
      const id = util.isNull(e) ? e.target.value : this.user.userId
      const $this = this
      this.validVisible.idVisible = false
      this.validMsg.idChkMsg = ''      

     if (!util.isNull(id)) {
        this.validVisible.idVisible = true
        this.validMsg.idChkMsg = this.label.reqdMsg
        return false
      }
      
      this.$http.get('/api/system/user/check', {params: {col: 'userId', param: id}}
      ).then(res => { 
        if (res.data) {
          this.validVisible.idVisible = true
          this.validMsg.idChkMsg = this.label.idOlMsg
          return false
        } else {
          if (!util.regEngNum.test(id) || !util.minMaxLength(id, 6, 12)) {
            this.validVisible.idVisible = true
            this.validMsg.idChkMsg = this.label.idConmMsg
            return false
          }  
        }
      }).catch(error => {
        console.log(error)
      })

    },
    isValidPwd: function (e){
      const pwd = this.$util.isNull(e) ? e.target.value : this.user.password
      this.validVisible.pwdVisible = false
      this.validMsg.pwdChkMsg = ''
      
      if (!this.$util.isNull(pwd)) {
        this.validVisible.pwdVisible = true
        this.validMsg.pwdChkMsg = this.label.reqdMsg
        return false
      }

      if(!/^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{10,15}$/.test(pwd)){
        this.validVisible.pwdVisible = true
        this.validMsg.pwdChkMsg = this.label.pwdConmMsg
        return false;
      }

      if(/(\w)\1\1\1/.test(pwd) || /(\W)\1\1\1/.test(pwd)){
        this.validVisible.pwdVisible = true
        this.validMsg.pwdChkMsg = this.label.pwdRepMsg
        return false;
      }
   
      return true;

    },
    isValidCfmPwd: function (e){
      const cfmPwd = this.$util.isNull(e) ? e.target.value : this.cfmPwd
      this.validVisible.cfmPwdVisible = false
      this.validMsg.cfmPwdChkMsg = ''

      if (!this.$util.isNull(cfmPwd)) {
        this.validVisible.cfmPwdVisible = true
        this.validMsg.cfmPwdChkMsg = this.label.reqdMsg
        return false
      } else if(this.user.password !== cfmPwd) {
        this.validVisible.cfmPwdVisible = true
        this.validMsg.cfmPwdChkMsg = this.label.pwdCfmMsg        
      }
      return true
    },    
    isValidName: function (e) {
      const util = this.$util
      const name = util.isNull(e) ? e.target.value : this.user.userName
      this.validVisible.nameVisible = false
      this.validMsg.nameChkMsg = ''

      if (!util.isNull(name)) {
        this.validVisible.nameVisible = true
        this.validMsg.nameChkMsg = this.label.reqdMsg
        return false
      } else if (!util.regKor.test(name) || !util.minMaxLength(name, 2, 5)) {
         this.validVisible.nameVisible = true
         this.validMsg.nameChkMsg = this.label.nmConmMsg
         return false
      }  
      return true
    },
    isValidTel: function (e) {
      const tel = this.$util.isNull(e) ? e.target.value : this.user.tel
      this.validVisible.telVisible = false
      this.validMsg.telChkMsg = ''
      if (!this.$util.isNull(tel)) {
        this.validVisible.telVisible = true
        this.validMsg.telChkMsg = this.label.reqdMsg
        return false
      }
      if (!/^(01[016789]{1}|02|0[3-9]{1}[0-9]{1})-?[0-9]{4}-?[0-9]{4}$/.test(tel)) {
         this.validVisible.telVisible = true
         this.validMsg.telChkMsg = this.label.telFormMsg
         return false
      }  
      return true
    },
    isValidEmail: function (e) {
      const email = this.$util.isNull(e) ? e.target.value : this.user.email
      this.validVisible.emailVisible = false
      this.validMsg.emailChkMsg = ''
      if (!this.$util.isNull(email)) {
        this.validVisible.emailVisible = true
        this.validMsg.emailChkMsg = this.label.reqdMsg
        return false
      }
      if (!/^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/.test(email)) {
         this.validVisible.emailVisible = true
         this.validMsg.emailChkMsg = this.label.emailFormMsg
         return false
      }  
      return true
    },
    isValidBirthday: function () {
      this.validVisible.birthdayVisible = false
      this.validMsg.birthdayChkMsg = ''
      if (null === this.user.birthday) {
        this.validVisible.birthdayVisible = true
        this.validMsg.birthdayChkMsg = this.label.reqdMsg
        return false
      }
      
      return true
    },
    isValidCcn: function (e) {
      const ccn = this.$util.isNull(e) ? e.target.value : this.userCcn
      this.validVisible.ccnVisible = false
      this.validMsg.ccnChkMsg = ''
      if (!this.$util.isNull(ccn)) {
        this.validVisible.ccnVisible = true
        this.validMsg.ccnChkMsg = this.label.reqdMsg
        return false
      }
      return true      
    },
    isValidGender: function () {
      this.validVisible.genderVisible = false
      this.validMsg.genderChkMsg = ''
      if (!this.$util.isNull(this.user.gender)) {
        this.validVisible.genderVisible = true
        this.validMsg.genderChkMsg = this.label.reqdMsg
        return false
      }
      return true
    },
    ccnSmsChk: function () {
      this.validVisible.telVisible = false
      this.validMsg.telChkMsg = ''
      let tel = this.user.tel

      this.$http.get('/api/system/user/check', {params: {col: 'tel', param: tel.split('-')[0]}}
      ).then(res => { 
        if (res.data) {
          this.validVisible.telVisible = true
          this.validMsg.telChkMsg = this.label.telOlMsg
        } else {
          this.ccnSms(tel)
        }
      }).catch(error => {
        console.log(error)
      })    
    },
    ccnSms:function (tel) {
      this.isCcnDisabled = false
      this.$http.get('/api/system/user/test', {params: {phone: tel.substring(1)}}
      ).then(res => { 
        this.$util.showAlert(this, 'success', this.label.ccnSendMsg)
        this.smsCcn = res.data
        EventBus.$emit('ccn-time', 'start')
        setTimeout(() => {
           if(!this.isCcnConfirm) {
             this.isCcnDisabled = true
             this.userCcn = null
             this.$util.showAlert(this, 'warning', this.label.ccnOverMsg)
           }
        }, this.ccnTimer * 1000)  
      }).catch(error => {
        console.log(error)
      })
    },
    ccnConfirm: function () {
      const util = this.$util

      if(!this.isValidCcn()) return false

      if(!util.regNum.test(this.userCcn)) {
        this.$util.showAlert(this, 'warning', this.label.ccnFormMsg)
        return false
      }

      if (this.smsCcn === parseInt(this.userCcn)) {
        util.showAlert(this, 'success', this.label.ccnCompMsg)
        this.isCcnConfirm = true
        EventBus.$emit('ccn-time', 'stop')
      } else {
        util.showAlert(this, 'error', this.label.ccnIcyMsg)
      }
    },
    signup: function() {
      this.isValidId()
      this.isValidPwd()
      this.isValidCfmPwd()
      this.isValidName()
      this.isValidTel()
      this.isValidEmail()
      this.isValidBirthday()
      this.isValidGender()  
      this.isValidCcn()


      for (let property in this.validVisible) {
        if (this.validVisible[property]) {
          return
        }
      }

      if(!this.isCcnConfirm) {
        this.$util.showAlert(this, 'warning', this.label.ccnIncMsg)
        return
      }

      const user = this.user
      const $this = this
      if(!this.$util.isNull(user.comment)) {
        this.$util.showConfirm(this, 'warning', this.label.userCfmMsg, function() {
        $this.signupApi(user)
        }, function(){
          $this.$refs.refComment.onFocus();
        })
      } else {
        this.signupApi(user)
      }
      
    },
    signupApi: function(user) {
      this.$http.post('/api/system/user', user
      ).then(res => {
        this.$util.showAlert(this, 'success', res.data.userName + this.label.singupMsg)
      }).catch(error => {
        console.log(error)
      })   
    }                      
  },
  created () {
    this.init()
  }

}
</script>
