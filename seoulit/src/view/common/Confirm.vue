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
        {{confirmMessage}}
      </b-col>
    </b-row>
    <span slot="footer" class="dialog-footer">
      <el-button v-on:click=close>Cancel</el-button>
      <el-button v-on:click=test>Confirm</el-button>
    </span>
  </el-dialog>
</template>

<script>
export default {
  props: {
    confirmType: String,
    confirmMessage: String,
    confirmCallback: Function,
    confirmCancel: Function
  },
  computed: {
    typeClass: function() {
      return require('@/assets/icon/' + this.confirmType + '.png')
    }
  },
  data() {
    return {
      centerDialogVisible: false
    };
  },
  methods: {
    handleClick(tab, event) {
      console.log(tab, event)
    },
    close:function () {
      this.$util.closeConfirm(this)
      this.confirmCancel()
    },
    test:function () {
      this.$util.closeConfirm(this)
      this.confirmCallback()
    }
  }
};
</script>
