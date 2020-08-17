<template>
  <div id="app">
    <component :is="layout">
        <transition name="fade" mode="out-in">
            <router-view></router-view>          
        </transition>
   </component>
   <alert v-if="alertFlag" :alertType=alertType :alertMessage=alertMessage></alert>
   <confirm v-if="confirmFlag" :confirmType=confirmType :confirmMessage=confirmMessage :confirmCallback=confirmCallback :confirmCancel=confirmCancel></confirm>
  </div>
</template>

<script>
import Alert from '@/view/common/Alert.vue'
import Confirm from '@/view/common/Confirm.vue'
const default_layout = "default";
export default {
  components: {
    Alert, Confirm
  },
  computed: {
    layout() {
      return (this.$route.meta.layout || default_layout) + '-layout';
    }
  },
  data: () => ({
    alertFlag: false,
    alertType: '',
    alertMessage: '',

    confirmFlag: false,
    confirmType: '',
    confirmMessage: '',
    confirmCallback: null,
    confirmCancel: null,

    label: null
  }),
  methods: {
    showAlert:function (type, message) {
      this.alertFlag = true
      this.alertType = type
      this.alertMessage = message
    },
    closeAlert:function () {
      this.alertFlag = false
    },
    showConfirm:function (type, message, callback, cancel) {
      this.confirmFlag = true
      this.confirmType = type
      this.confirmMessage = message
      this.confirmCallback = callback
      this.confirmCancel = cancel
    },
    closeConfirm:function () {
      this.confirmFlag = false
    }
  },
  // created () {
  //   const lang = 'ko-kr'
  //   this.$http.get('/api/system/label/app', {params: {application: 'SIGNUP', lang: lang}}
  //   ).then(res => {
  //     this.label = res.data
  //   }).catch(error => {
  //     console.log(error)
  //   }) 
  // }
}
</script>

<style lang="scss">
  @import "assets/base.scss";
</style>
