<template>
    <el-form label-position="top" label-width="100px" :model="formLabelAlign">
    <b-row>
      <b-col cols="3">
        <el-form-item label="UserId">
          <el-input v-model="currentData.userId" readonly></el-input>
        </el-form-item>
      </b-col>
      <b-col cols="3">
        <el-form-item label="UserName">
          <el-input v-model="currentData.userName" readonly></el-input>
        </el-form-item>
      </b-col>
      <b-col cols="3">
        <el-form-item label="Tel">
          <el-input v-model="currentData.tel" suffix-icon="el-icon-edit"></el-input>
        </el-form-item>
      </b-col>
      <b-col cols="3">
        <el-form-item label="Status">
          <el-input v-model="currentData.status"></el-input>
        </el-form-item>
      </b-col>
    </b-row>
    <b-row>
      <b-col cols="3">
        <el-form-item label="Email">
          <el-input v-model="currentData.email" readonly></el-input>
        </el-form-item>
      </b-col>
      <b-col cols="3">
        <el-form-item label="Birthday">
          <el-input v-model="currentData.birthday" readonly></el-input>
        </el-form-item>
      </b-col>
      <b-col cols="6">
        <el-form-item label="Address">
          <el-input v-model="currentData.address" readonly></el-input>
        </el-form-item>
      </b-col>
    </b-row>
    <b-row>
      <b-col cols="3">
        <el-form-item label="Creationr">
          <el-input v-model="currentData.createId" readonly></el-input>
        </el-form-item>
      </b-col>
      <b-col cols="3">
        <el-form-item label="CreationDate">
          <el-input :value="$util.dateTime(currentData.createDt)" readonly></el-input>
        </el-form-item>
      </b-col>
      <b-col cols="3">
        <el-form-item label="Updater">
          <el-input v-model="currentData.updateId" readonly></el-input>
        </el-form-item>
      </b-col>
      <b-col cols="3">
        <el-form-item label="UpdateDate">
          <el-input :value="$util.dateTime(currentData.updateDt)" readonly>
          </el-input>
        </el-form-item>
      </b-col>
    </b-row>
  </el-form>
</template>
<script>
export default {
  components: {
  },
  props: {
    currentDataId: Number
  },
  watch: {
    currentDataId: function (id) {
      if(this.$util.isNull(id)) {
        this.getRowData(id)
      }
    }
  },
  data: () => ({
    currentData: {},
    validMsg: {
      idChkMsg: '',
      nameChkMsg: '',
      keChkMsg: ''
    },
    validVisible: {
      idVisible: false,
      nameVisible: false
    },
    formLabelAlign: {
        name: '',
        region: '',
        type: ''
    },
    isEditing: false
  }),
  methods: {
    getRowData:function (id) {
      this.$http.get('/api/system/user/' + id
      ).then(res => {
        this.currentData = res.data
        this.activeName = 'detail'
      }).catch(error => {
        console.log(error)
      })
   },
  } 
}
</script>