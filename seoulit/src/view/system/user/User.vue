<template>
  <div>
    <system-title
      :heading='heading'
      :subheading='subheading'
      :icon='icon'
      :grid='listGrid'
      :activeName='activeName'
      :del='del'
      :add='add' />

    <div class="content">
      <div class="main-card mb-3 card">
        <div class="card-body">
          <el-tabs v-model="activeName" v-on:tab-click="handleClick">
            <el-tab-pane label="List" name="list">
              <data-tables :data="listGrid.data" :filters="listGrid.filters" :page-size="listGrid.pageProps.pageSize"
                :pagination-props="{pageSizes: listGrid.pageProps.pageSizes }"
                v-on:row-click="moveDetail">
                <el-table-column v-for="title in listGrid.titles" :prop="title.prop" :label="title.label" :key="title.prop">
                </el-table-column>
              </data-tables>
            </el-tab-pane>
            <!-- <el-tab-pane v-if="this.listGrid.currentData.hasOwnProperty('id')" label="Detail" name="detail"> -->
              <el-tab-pane  label="Detail" name="detail">
              <user-detail
                :currentDataId='listGrid.currentDataId'
              />
<!-- 
              <el-form label-position="top" label-width="100px" :model="formLabelAlign">
                <b-row>
                  <b-col cols="3">
                    <el-form-item label="UserId">
                      <el-input v-model="listGrid.currentData.userId" readonly></el-input>
                    </el-form-item>
                  </b-col>
                  <b-col cols="3">
                    <el-form-item label="UserName">
                      <el-input v-model="listGrid.currentData.userName" readonly></el-input>
                    </el-form-item>
                  </b-col>
                  <b-col cols="3">
                    <el-form-item label="Tel">
                      <el-input v-model="listGrid.currentData.tel" suffix-icon="el-icon-edit"></el-input>
                    </el-form-item>
                  </b-col>
                  <b-col cols="3">
                    <el-form-item label="Status">
                      <el-input v-model="listGrid.currentData.status"></el-input>
                    </el-form-item>
                  </b-col>
                </b-row>
                <b-row>
                  <b-col cols="3">
                    <el-form-item label="Email">
                      <el-input v-model="listGrid.currentData.email" readonly></el-input>
                    </el-form-item>
                  </b-col>
                  <b-col cols="3">
                    <el-form-item label="Birthday">
                      <el-input v-model="listGrid.currentData.birthday" readonly></el-input>
                    </el-form-item>
                  </b-col>
                  <b-col cols="6">
                    <el-form-item label="Address">
                      <el-input v-model="listGrid.currentData.address" readonly></el-input>
                    </el-form-item>
                  </b-col>
                </b-row>
                <b-row>
                  <b-col cols="3">
                    <el-form-item label="Creationr">
                      <el-input v-model="listGrid.currentData.createId" readonly></el-input>
                    </el-form-item>
                  </b-col>
                  <b-col cols="3">
                    <el-form-item label="CreationDate">
                      <el-input :value="dateTime(listGrid.currentData.createDt)" readonly></el-input>
                    </el-form-item>
                  </b-col>
                  <b-col cols="3">
                    <el-form-item label="Updater">
                      <el-input v-model="listGrid.currentData.updateId" readonly></el-input>
                    </el-form-item>
                  </b-col>
                  <b-col cols="3">
                    <el-form-item label="UpdateDate">
                      <el-input :value="dateTime(listGrid.currentData.updateDt)" readonly>
                      </el-input>
                    </el-form-item>
                  </b-col>
                </b-row>
              </el-form> -->
            </el-tab-pane>
            <el-tab-pane label="Role" name="third">
            </el-tab-pane>
          </el-tabs>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import SystemTitle from "@/Layout/Components/SystemTitle.vue";
import UserDetail from "./UserDetail.vue";
export default {
  components: {
    SystemTitle, UserDetail    
  },
  data: () => ({
    heading: 'User',
    subheading: 'Wide icons selection including from flag icons to FontAwesome and other icons libraries.',
    icon: 'pe-7s-users',
    activeName: 'list',
    listGrid: {
      data: [],
      titles: [{
        prop: 'userId',
        label: 'UserId'
      }, {
        prop: 'userName',
        label: 'UserName'
      }, {
        prop: 'tel',
        label: 'Tel'
      }, {
        prop: 'status',
        label: 'Status'
      }],
      filters: [
        {
          prop: ['userId', 'userName', 'tel', 'status'],
          value: ''
        }
      ],
      pageProps: {
        pageSize: 5,
        pageSizes: [5, 10, 15]
      },
      currentDataId: null
    },
    
    formLabelAlign: {
        name: '',
        region: '',
        type: ''
    }
  }),
  methods: {
    initialize: function () {
      this.$http.get('/api/system/user'
      ).then(res => {
        this.listGrid.data = res.data
      }).catch(error => {
        console.log(error)
      })
    },
    handleClick:function (tab) {
      if (tab.name === 'list') {
        this.listGrid.currentDataId = null
      }
    },
    moveDetail:function (row) {
      this.listGrid.currentDataId = row.id
      this.activeName = 'detail'
      // this.$http.get('/api/system/user/' + row.id
      // ).then(res => {
      //   this.listGrid.currentData = res.data
      //   console.log(new Date(res.data.createDt).toLocaleString())
      //   this.activeName = 'detail'
      // }).catch(error => {
      //   console.log(error)
      // })
   },
    // del:function () {
    //   this.$util.showAlert(this, 'success', '테스트')
    // }
    add: function () {

    },
    del:function () {
      let $this = this
      this.$util.showConfirm(this, 'error', '삭제하시겠습니까?', function() {
        $this.$util.showAlert($this, 'success', '처리되었습니다')
      })
    }
  },
  created() {
    this.initialize()
  },
}
</script>
