<template>
    <el-dialog title="编辑部门" :visible.sync="dialogFormVisible">
      <!--数据模型对象-->
      <el-form :model="dept" label-width="120px">
        <el-form-item label="部门名称">
          <el-input v-model="dept.name" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="部门编码" >
          <el-input v-model="dept.code" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="部门负责人">
          <el-input v-model="dept.manager" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="部门简介">
          <el-input v-model="dept.introduce" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="saveDept">确 定</el-button>
      </div>
    </el-dialog>
</template>

<script>
import {saveOrUpdate} from '@/api/base/dept'
export default {
    data() {
        return {
            dept: {},
            parentId: '',
            dialogFormVisible: false
        }
    },
    methods: {
        saveDept: function() {
            saveOrUpdate(this.dept).then(res => {
                this.$message({
                    type: res.data.success ? 'success' : 'error',
                    message: res.data.message
                })
                if (res.data.success) {
                    this.$parent.getList()
                }
            })
            this.dialogFormVisible = false
        }
    }
}
</script>
<style>
</style>
