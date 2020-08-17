<template>
    <el-dialog
    :visible.sync="dialogVisible"
    width="60%"
    :before-close="handleClose"
    :show-close="false"
    >
    <span slot="title" class="dialog-title">
      <div class="c-wrapper">
        <div class="c-left">
          <span class="el-dialog__title">Domain Detail</span>
        </div>
        <div class="c-right">
          <el-button @click="handleClose">Cancel</el-button>
          <el-button type="primary" v-on:click="save">Save</el-button>
        </div>
      </div>
    </span>
    <el-form label-position="top" label-width="100px">
      <b-row>
        <b-col cols="3">
          <input-from
              label='DomainId'
              :iValue.sync="listGrid.currentData.domainId"
              :valid='validVisible.idVisible'
              :validMsg='validMsg.idChkMsg'
              :validating="isValidId"
              :disabled='this.status !== "add" ? true : false'
          />
        </b-col>
        <b-col cols="3">
          <input-from
              label='DomainName'
              :iValue.sync="listGrid.currentData.domainName"
              :valid='validVisible.nameVisible'
              :validMsg='validMsg.nameChkMsg'
              :validating="isValidName"
          />
        </b-col>
        <b-col cols="6">
          <el-form-item class="no-margin-b" label="Description">
            <el-input v-model="listGrid.currentData.description"></el-input>
          </el-form-item>
        </b-col>
      </b-row>
    </el-form>
    <p class="si-divider"></p>
    <div class="c-wrapper" style="height: 59px">
      <div class="c-left">
        <md-field class="no-margin-b">
          <label>Search..</label>
          <md-input v-model="listGrid.filters[0].value"></md-input>
        </md-field>
      </div>
      <div class="c-right">
        <el-button v-on:click="add" style="margin-top: 8px;" class="mr-2 btn-transition" type="primary" icon="el-icon-plus" circle></el-button>
      </div>
    </div>
    <data-tables :data="listGrid.data" :filters="listGrid.filters" :page-size="listGrid.pageProps.pageSize"
      :pagination-props="{pageSizes: listGrid.pageProps.pageSizes }"
      size="medium"
      >
     <el-table-column :width='listGrid.titles[1].width'>
        <template slot="header">
          {{listGrid.titles[1].label}} <span class="red-c">*</span> 
        </template>
        <template slot-scope="props">
          <el-input maxlength="15" v-model="props.row.key" v-on:change="$util.isGridStatus(props.row)"></el-input>
        </template>
      </el-table-column>
      <el-table-column :width='listGrid.titles[2].width'>
        <template slot="header">
          {{listGrid.titles[2].label}} <span class="red-c">*</span> 
        </template>
        <template slot-scope="props">
          <el-input maxlength="15" v-model="props.row.value" v-on:change="$util.isGridStatus(props.row)"></el-input>
        </template>
      </el-table-column>
      <el-table-column :label='listGrid.titles[3].label' :width='listGrid.titles[3].width'>
        <template slot-scope="props">
          <el-input maxlength="3" v-on:blur="isValidNo" v-model="props.row.no"></el-input>
          <!-- <el-input type="text" maxlength="3" v-on:keypress.native="restrictChars" v-model="props.row.no"></el-input> -->
        </template>
      </el-table-column>
      <el-table-column :label='listGrid.titles[4].label' :width='listGrid.titles[4].width'>
        <template slot-scope="props">
          <el-switch v-model="props.row.keyUsing" v-on:change="$util.isGridStatus(props.row)"></el-switch>
        </template>
      </el-table-column>
      <el-table-column :label='listGrid.titles[5].label'>
        <template slot-scope="props">
          <el-input v-model="props.row.description" v-on:change="$util.isGridStatus(props.row)"></el-input>
        </template>
      </el-table-column>
      <el-table-column width="70x">
         <template slot-scope="props">
       <el-button v-on:click="del(props)" class="mr-2 btn-transition" type="danger" icon="el-icon-delete" circle></el-button>
         </template>
       </el-table-column>
    </data-tables>
    </el-dialog> 
</template>

<script>
import InputFrom from "@/Layout/Components/From/InputFrom.vue";
export default {
  components: {
    InputFrom
  },
  props: {
    data: Object,
    status: String,
    dialogVisible: Boolean
  },
  computed: {
    ttt() {
     return (e) => {
      console.log('eeee', e)
      return  String(e).replace(/[^0-9]/g, '');
      }
    },
    isStatus: function() {      
      if (this.status !== 'add') {
        return true
      }
      return false
    },
  },
  watch: {
    dialogVisible: function (visible) {
      if (visible) {
        if (this.status === 'modify') this.getDetail(this.data.id)
        else this.listGrid.currentData.status = this.status
      } else {
        this.listGrid.data = []
        this.listGrid.currentData = {}
        this.deleteData = []
        this.isEditing = false
        for (let key in this.validVisible) {
          this.validVisible[key] = false
        }
      }
    }
  },
  data: () => ({
    listGrid: {
      data: [],
      titles: [
        {prop: 'domainId', label: 'DomainId', width: '150px'},
        {prop: 'key', label: 'Key', width: '200px'},
        {prop: 'value', label: 'Value', width: '200px'},
        {prop: 'order', label: 'Order', width: '80px'},
        {prop: 'keyUsing', label: 'Using', width: '80px'},
        {prop: 'description', label: 'Description', width: '150px'},
      ],
      filters: [
        {
          prop: ['domainId', 'key', 'value', 'order', 'description'],
          value: ''
        }
      ],
      pageProps: {
        pageSize: 3,
        pageSizes: [3, 6, 9]
      },
      currentData: {},
      deleteData: []
    },
    validMsg: {
      idChkMsg: '',
      nameChkMsg: '',
      keChkMsg: ''
    },
    validVisible: {
      idVisible: false,
      nameVisible: false
    },
    isEditing: false
  }),
  methods: {
    changeToggle: function(form) {
      console.log(form)
            if(form.box.style.imeMode == "active")
                    form.box.style.imeMode = "inactive";
            else
                    form.box.style.imeMode = "active";
    },

restrictChars: function($event) {

  console.log('11111111111')
    if ($event.charCode === 0 || /\d/.test(String.fromCharCode($event.charCode))) {
        return true
    } else {
        $event.preventDefault();
    }
},
  removeChar: function(event) {
    console.log('event', event)
    if(event.keyCode < 48 || event.keyCode > 57) {
      event.target.value = ''
      return false
    }
    // event = event || window.event;
    // var keyID = (event.which) ? event.which : event.keyCode;
    // if ( keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39 )
    //     return;
    // else
    //     event.target.value = event.target.value.replace(/[^0-9]/g, "");
},
    getDetail: function (id) {
      this.$http.get('/api/system/domain/' + id
      ).then(res => {
        this.listGrid.data = res.data.domainDetail
        this.listGrid.currentData = res.data
        this.listGrid.currentData.status = this.status
      }).catch(error => {
        console.log(error)
      })
    },
    handleOpen:function () {
      this.dialogVisible = true
    },
    handleClose:function () {
      let $this = this
      const gridEditing = this.$util.isNull(this.listGrid.data.filter(row => row.status !== null))
      const gridDeleting = this.$util.isNull(this.listGrid.deleteData)
      if(this.isEditing || gridEditing || gridDeleting) {
        this.$util.showConfirm(this, 'warning', '변경사항이 있습니다. 종료하시겠습니까?', function() {
        $this.$emit('handleClose')  
        }, function(){})
      } else {
        this.$emit('handleClose')
      }
    },
    add:function () {
      let addRow = {key: '', value: '', keyUsing: true, status: 'add'}
      this.listGrid.data.unshift(addRow)
    },
    del:function (props) {
      let $this = this
      let row = props.row
      let index = props.$index
      this.$util.showConfirm(this, 'error', '삭제하시겠습니까?', function() {
        if (row.id) {
          row.status = 'del'
          $this.listGrid.deleteData.push(row)
        }
        $this.listGrid.data.splice(index, 1)
      }, function(){})
    },
    isValidId: function (e) {
      if(this.status === 'modify') return true
      
      this.isEditing = true
      const domainId = e ? e.target.value : this.listGrid.currentData.domainId
      if (!this.$util.isNull(domainId)) {
        this.validVisible.idVisible = true
        this.validMsg.idChkMsg = '값을 입력해주세요'
        return false
      }
      this.$http.get('/api/system/domain/check', {params: {domainId: domainId}}
      ).then(res => {
        if (res.data) {
          this.validVisible.idVisible = true
          this.validMsg.idChkMsg = '중복되는 코드가 있습니다'
          return false
        } else {
          this.validVisible.idVisible = false
          this.validMsg.idChkMsg = ''
          return true   
        }
      }).catch(error => {
        console.log(error)
      })
    },
    isValidName: function (e) {
      const domainName = e ? e.target.value : this.listGrid.currentData.domainName

      this.isEditing = true
      if (!this.$util.isNull(domainName)) {
        this.validVisible.nameVisible = true
        this.validMsg.nameChkMsg = '값을 입력해주세요'
        return false
      }
      this.validVisible.nameVisible = false
      this.validMsg.nameChkMsg = ''
      return true
    },
    isValidNo: function(e) {
      let util = this.$util
      let inputVal = e.target.value
      if(!util.regInt.test(inputVal)) util.showAlert(this, 'warning', '숫자만 입력 가능합니다')
      e.target.value = util.isFloat(inputVal)
    },
    isValidGrid: function(gridData) {
      let util = this.$util
      const blank  = gridData.some(row => {
        return !util.isNull(row.key) || !util.isNull(row.value)
      })
      if(blank) {
        util.showAlert(this, 'warning', '그리드 값을 입력해주세요')
        return false
      }

      const duplicate = util.isDuplicated(gridData, 'key')
      if(duplicate.length !== 0) {
        util.showAlert(this, 'warning', `중복된 키값이 존재합니다. ${duplicate}`)
        return false
      }
      return true
    },
    save: function () {
      this.isValidId()
      const isValidId = this.validVisible.idVisible
      const isValidName = this.isValidName()
      const isValidGrid = this.isValidGrid(this.listGrid.data)

      if (!isValidId && isValidName && isValidGrid) {
        let $this = this
        let domain = this.listGrid.currentData
        domain.domainDetail = this.listGrid.data.filter(row => row.status !== null).concat(this.listGrid.deleteData)

        this.$http({
          method: this.status === 'add' ? 'post' : 'put',
          url: '/api/system/domain',
          data: domain
        }).then(res => {
          $this.$util.showAlert(this, 'success', '처리되었습니다')
          $this.handleClose()
          console.log(res)
        }).catch(error => {
          console.log(error)
        })

        // this.$http.post('/api/system/domain', domain
        // ).then(res => {
        //   console.log('ttttttttttttttt', res)
        // }).catch(error => {
        //   console.log(error)
        // })
      }

    }
  },
  created() {
    // this.initialize()
  },
}
</script>
