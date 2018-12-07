<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加多张图片 测试</title>
<script src="statics/js/vue2.2.2.js"></script>
<style>
	.upload_warp_img_div_del {
      position: absolute;
      top: 6px;
      width: 16px;
      right: 4px;
    }

    .upload_warp_img_div_top {
      position: absolute;
      top: 0;
      width: 100%;
      height: 30px;
      background-color: rgba(0, 0, 0, 0.4);
      line-height: 30px;
      text-align: left;
      color: #fff;
      font-size: 12px;
      text-indent: 4px;
    }

    .upload_warp_img_div_text {
      white-space: nowrap;
      width: 80%;
      overflow: hidden;
      text-overflow: ellipsis;
    }

    .upload_warp_img_div img {
      max-width: 100%;
      max-height: 100%;
      vertical-align: middle;
    }

    .upload_warp_img_div {
      position: relative;
      height: 100px;
      width: 120px;
      border: 1px solid #ccc;
      margin: 0px 30px 10px 0px;
      float: left;
      line-height: 100px;
      display: table-cell;
      text-align: center;
      background-color: #eee;
      cursor: pointer;
    }

    .upload_warp_img {
      border-top: 1px solid #D2D2D2;
      padding: 14px 0 0 14px;
      overflow: hidden
    }

    .upload_warp_text {
      text-align: left;
      margin-bottom: 10px;
      padding-top: 10px;
      text-indent: 14px;
      border-top: 1px solid #ccc;
      font-size: 14px;
    }

    .upload_warp_right {
      float: left;
      width: 57%;
      margin-left: 2%;
      height: 100%;
      border: 1px dashed #999;
      border-radius: 4px;
      line-height: 130px;
      color: #999;
    }

    .upload_warp_left img {
      margin-top: 32px;
    }

    .upload_warp_left {
      float: left;
      width: 40%;
      height: 100%;
      border: 1px dashed #999;
      border-radius: 4px;
      cursor: pointer;
    }

    .upload_warp {
      margin: 14px;
      height: 130px;
      width:  1550px;
    }

    .upload {
      border: 1px solid #ccc;
      background-color: #fff;
      width: 650px;
      box-shadow: 0px 1px 0px #ccc;
      border-radius: 4px;
    }

    .hello {
      width: 650px;
      margin-left: 27%;
      text-align: center;
    }
    .upload_button{
      width: 100px;
      height: 30px;
      cursor:pointer 
    }
</style> 
 
</head>
<body> 
<form action="product/imgsd" method="post" enctype="multipart/form-data">  
<div id="app">
  <div class="hello">
    <div class="upload">
      <div class="upload_warp">
        <div class="upload_warp_left" @click="fileClick">
          <img src="statics/img/upload.png">
        </div> 
      </div>
      <div class="upload_warp_text">
        选中{{imgList.length}}张文件，共{{bytesToSize(this.size)}}
      </div>
      <input @change="fileChange($event)" type="file" name="imgs" id="upload_file" multiple style="display: none">
      <div class="upload_warp_img" v-show="imgList.length!=0">
        <div class="upload_warp_img_div" v-for="(item,index) of imgList">
          <div class="upload_warp_img_div_top">
            <div class="upload_warp_img_div_text">
               {{item.file.name}}  
            </div>
             <img src="statics/img/del.png" class="upload_warp_img_div_del" @click="fileDel(index)">
          </div>
             <img :src="item.file.src"> 
          </div> 
      </div> 
      <input class="upload_button" type="submit" value="提交" /> 
    </div> 
  </div> 
</div>
</form>
<script>
 
  //  import up from  './src/components/Hello'
  var app = new Vue({
    el: '#app',
    data(){
      return {
        imgList: [],
        size: 0
      }
    },
    methods: {
      fileClick(){
        document.getElementById('upload_file').click()
      },
      fileChange(el){
        if (!el.target.files[0].size) return;
        this.fileList(el.target.files);
        el.target.value = ''
      },
      fileList(files){
    	   
        for (let i = 0; i < files.length; i++) {
          this.fileAdd(files[i]); 
           
        }
      },
      fileAdd(file){ 
        this.size = this.size + file.size;//总大小
        let reader = new FileReader();
        reader.vue = this;
        reader.readAsDataURL(file);
        reader.onload = function () {
        	 
          file.src = this.result;
           
          this.vue.imgList.push({
            file
           
          });
        }
      },
      fileDel(index){
        this.size = this.size - this.imgList[index].file.size;//总大小
        this.imgList.splice(index, 1);
      },
      bytesToSize(bytes){
        if (bytes === 0) return '0 B';
        let k = 1000, // or 1024
          sizes = ['B', 'KB', 'MB', 'GB', 'TB', 'PB', 'EB', 'ZB', 'YB'],
          i = Math.floor(Math.log(bytes) / Math.log(k));
        return (bytes / Math.pow(k, i)).toPrecision(3) + ' ' + sizes[i];
      },
      dragenter(el){
        el.stopPropagation();
        el.preventDefault();
      },
      dragover(el){
        el.stopPropagation();
        el.preventDefault();
      },
      drop(el){
        el.stopPropagation();
        el.preventDefault();
        this.fileList(el.dataTransfer.files);
      }
    }    
  })  
</script>
</body>
</html>