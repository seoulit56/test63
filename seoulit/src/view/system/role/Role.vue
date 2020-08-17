<template>
  <div>
    <page-title :heading=heading :subheading=subheading :icon=icon :grid=listGrid></page-title>

    <div class="content">
      <div class="main-card mb-3 card">
        <div class="card-body">
          <el-tabs v-model="activeName" @tab-click="handleClick">
            <el-tab-pane label="List" name="first">
              <data-tables :data="listGrid.data" :filters="listGrid.filters">
                <el-table-column v-for="title in listGrid.titles" :prop="title.prop" :label="title.label" :key="title.prop">
                </el-table-column>
              </data-tables>
            </el-tab-pane>
            <el-tab-pane label="Detail" name="second">Detail</el-tab-pane>
            <el-tab-pane label="Role" name="third">Role</el-tab-pane>
          </el-tabs>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

  import PageTitle from "@/Layout/Components/PageTitle.vue";

  export default {
    components: {
      PageTitle
    },
    data: () => ({
      heading: 'User',
      subheading: 'Wide icons selection including from flag icons to FontAwesome and other icons libraries.',
      icon: 'pe-7s-users',
      activeName: 'first',
      listGrid: {
        data: [
          { name: 'USA', rank: 1 },
          { name: 'China', rank: 2 }
        ],
        titles: [{
          prop: 'name',
          label: 'Name'
        }, {
          prop: 'rank',
          label: 'Rank'
        }],
        filters: [
          {
            prop: 'name',
            value: ''
          }
        ]
      }
    }),
    methods: {
      handleClick(tab, event) {
        console.log(tab, event);
      }
    }
  }
</script>
