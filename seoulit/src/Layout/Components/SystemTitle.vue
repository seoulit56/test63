<template>
    <div class="app-page-title" style="padding-top: 15px;padding-bottom: 15px;">
        <div class="page-title-wrapper">
            <div class="page-title-heading">
                <div class="page-title-icon">
                    <i :class="icon"/>
                </div>
                <div>
                    {{heading}}
                    <div v-show="!this.grid.currentDataId" class="page-title-subheading">
                      <md-field style="margin-bottom: 0px">
                        <label>Search..</label>
                        <md-input v-model="grid.filters[0].value"></md-input>
                      </md-field>
                    </div>
                </div>
            </div>
            <div class="page-title-actions">
              <el-button class="mr-2 btn-transition" v-show="isEditing" type="danger" v-on:click=del icon="el-icon-delete" circle></el-button>
              <el-button class="mr-2 btn-transition" v-show="isEditing" type="success"  icon="el-icon-edit" circle></el-button>
              <el-button class="mr-2 btn-transition" v-show="!this.grid.currentDataId" type="primary" v-on:click=add icon="el-icon-plus" circle></el-button>
            </div>
        </div>
    </div>
</template>

<script>
export default {
  props: {
      icon: String,
      heading: String,
      subheading: String,
      grid: Object,
      activeName: String,
      del: Function,
      add: Function
  },
  computed: {
    isEditing: function() {
      if (this.grid.currentDataId && this.activeName  && this.activeName !== 'list') {
        return true
      }
      return false
    }
  }
}
</script>
