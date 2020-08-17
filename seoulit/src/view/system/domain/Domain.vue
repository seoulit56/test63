<template>
  <div>
    <system-title
      :heading=heading
      :subheading=subheading
      :icon=icon
      :grid=listGrid
      :del=del
      :add=add />

    <div class="content">
      <div class="main-card mb-3 card">
        <div class="card-body">
          
          <data-tables :data="listGrid.data" :filters="listGrid.filters" :page-size="listGrid.pageProps.pageSize"
            :pagination-props="{pageSizes: listGrid.pageProps.pageSizes }"
            >
             <el-table-column :label='listGrid.titles[0].label' :prop='listGrid.titles[0].prop' :width='listGrid.titles[0].width' />
             <el-table-column :label='listGrid.titles[1].label' :prop='listGrid.titles[1].prop' :width='listGrid.titles[1].width' />
             <el-table-column :label='listGrid.titles[2].label' :prop='listGrid.titles[2].prop' />
             <el-table-column width="70px">
                <template slot-scope="props">
              <el-button class="mr-2 btn-transition" type="success" v-on:click=modify(props.row) icon="el-icon-edit" circle></el-button>
                </template>
              </el-table-column>
             <el-table-column width="70x">
                <template slot-scope="props">
              <el-button class="mr-2 btn-transition" type="danger" v-on:click=del(props) icon="el-icon-delete" circle></el-button>
                </template>
              </el-table-column>
          </data-tables>
        </div>
      </div>
    </div>
     
    <domain-detail
      :data='listGrid.currentData'
      :status='status'
      :dialogVisible='dialogVisible'
      v-on:handleClose="handleClose"
    />
  </div>
  
</template>

<script>
import SystemTitle from "@/Layout/Components/SystemTitle.vue";
import DomainDetail from "./DomainDetail.vue";
export default {
  components: {
    SystemTitle, DomainDetail
  },
  data: () => ({
    heading: 'Domain',
    subheading: 'Wide icons selection including from flag icons to FontAwesome and other icons libraries.',
    icon: 'pe-7s-global',
    dialogVisible: false,
    status: '',
    listGrid: {
      data: [],
      titles: [
        {prop: 'domainId', label: 'DomainId', width: '200'},
        {prop: 'domainName', label: 'DomainName', width: '200'},
        {prop: 'description', label: 'Description', width: '150'},
      ],
      filters: [
        {
          prop: ['domainId', 'domainName', 'description'],
          value: ''
        }
      ],
      pageProps: {
        pageSize: 5,
        pageSizes: [5, 10, 15]
      },
      currentData: {domainId: '', domainName: '', description: ''}
    },
      formLabelAlign: {
        name: '',
        region: '',
        type: ''
      }
  }),
  methods: {
    initialize: function () {
      this.$http.get('/api/system/domain'
      ).then(res => {
        this.listGrid.data = res.data
      }).catch(error => {
        console.log(error)
      })
    },
    handleClose:function () {
      this.listGrid.currentData = {}
      this.dialogVisible = false
      this.initialize()
    },
    add:function () {
      this.status = 'add'
      this.dialogVisible = true
    },
    modify:function (row) {
      this.listGrid.currentData = row
      this.status = 'modify'
      this.dialogVisible = true
    },
    del:function (props) {
      let $this = this
      let rowId = props.row.id
      let index = props.$index
      this.$util.showConfirm(this, 'error', '삭제하시겠습니까?', function() {
        this.$http.delete('/api/system/domain/' + rowId
        ).then(res => {
         console.log(res.data)
          $this.$util.showAlert(this, 'success', '처리되었습니다')
          $this.listGrid.data.splice(index, 1)
        }).catch(error => {
          $this.$util.showAlert(this, 'warning', error.response.data)
        })
      }, function(){})
    }
  },
  created() {
    this.initialize();  
  },
}
</script>
