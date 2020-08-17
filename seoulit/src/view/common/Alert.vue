<template>
  <el-dialog
    :visible=true
    :show-close=false
    width="30%"
    center>
    <b-row>
      <b-col cols='2'>
        <img v-bind:src=typeClass>
      </b-col>
      <b-col cols='10' style="margin:auto">
        {{alertMessage}}
      </b-col>
    </b-row>
    <span slot="footer" class="dialog-footer">
      <el-button v-on:click=close>Confirm</el-button>
    </span>
  </el-dialog>
</template>

<script>
export default {
  props: {
    alertType: String,
    alertMessage: String
  },
  computed: {
    typeClass: function() {
      return require('@/assets/icon/' + this.alertType + '.png')
    }
  },
  data() {
    return {
    }
  },
  methods: {
    close:function () {
      this.$util.closeAlert(this)
    }
  }
}
</script>
