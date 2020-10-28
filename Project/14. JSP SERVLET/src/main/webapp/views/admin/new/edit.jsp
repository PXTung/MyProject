<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-news" />
<c:url var ="NewURL" value="/admin-new"/>
<html>
<head>
<title>EDIT NEWS</title>
</head>
<body>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs" id="breadcrumbs">
				<script type="text/javascript">
					try {
						ace.settings.check('breadcrumbs', 'fixed')
					} catch (e) {
					}
				</script>
				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">HOME</a>
					</li>
					<li class="active">EDIT</li>
				</ul>
				<!-- /.breadcrumb -->
			</div>
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
						<div class="alert alert-${alert}">
  							${message}
						</div>
						<form id="formSubmit">
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Category</label>
								<div class="col-sm-9">
									<select class="form-control" id="categoryCode"
										name="categoryCode">
										<c:if test="${empty model.categoryCode}">
											<option value="">Choose news type</option>
											<c:forEach var="item" items="${categories}">
												<option value="${item.code}">${item.name}</option>
											</c:forEach>
										</c:if>

										<c:if test="${not empty model.categoryCode}">
											<option value="">Choose news type</option>
											<c:forEach var="item" items="${categories}">
												<option value="${item.code}"
													<c:if test="${item.code == model.categoryCode}">selected="selected"</c:if>>
													${item.name}</option>
											</c:forEach>
										</c:if>
									</select>
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Title</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="title" name="title"
										value="${model.title}" />
								</div>
							</div>

							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Thumbnail</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="thumbnail"
										name="thumbnail" value="" />
								</div>
							</div>

							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Short
									Description</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="shortDescription"
										name="shortDescription" value="${model.shortDescription}" />
								</div>
							</div>

							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Content</label>
								<div class="col-sm-9">
									<textarea row="" cols="" id="content" name="content" style="width: 820px; height: 150px">${model.content}</textarea>
								</div>
							</div>

							<br /> <br />
							<div class="form-group">
								<div class="col-sm-12">
									<c:if test="${not empty model.id }">
										<input type="button"
											class="btn btn-white btn-warning btn-bold"
											value="Update News" id="btnAddOrUpdateNew" />
									</c:if>
									<c:if test="${empty model.id }">
										<input type="button"
											class="btn btn-white btn-warning btn-bold" value="Add News"
											id="btnAddOrUpdateNew" />
									</c:if>
								</div>
							</div>
							<input type="hidden" value="${model.id}" id="id" name="id" />
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
<script type="text/javascript">
	var editor = '';
	$(document).ready(function(){
		editor = CKEDITOR.replace( 'content');
	});

	$('#btnAddOrUpdateNew').click(function (e){
		e.preventDefault();
		var data = {};
		var formData = $('#formSubmit').serializeArray();
		$.each(formData, function(i, v){
			data[""+v.name+""] = v.value;
		});
		data["content"] = editor.getData();
		var id = $('#id').val();
		if(id == ""){
			addNews(data);
		}else{
			updateNews(data);
		}
	});

	function addNews(data){
		$.ajax({
			url: '${APIurl}',
			type: 'POST',
			contentType: 'application/json',
			data: JSON.stringify(data),
			dataType: 'json',
			success: function(result){
				window.location.href = "${NewURL}?type=edit&id="+result.id+"&message=insert_success&alert=success";
			},
			error: function(error){
				window.location.href = "${NewURL}?type=list&page=1&maxPageItem=5&message=error_system&alert=danger";
			},
		});
	}

	function updateNews(data){
		$.ajax({
			url: '${APIurl}',
			type: 'PUT',
			contentType: 'application/json',
			data: JSON.stringify(data),
			dataType: 'json',
			success: function(result){
				window.location.href = "${NewURL}?type=edit&id="+result.id+"&message=update_success&alert=success";
			},
			error: function(error){
				window.location.href = "${NewURL}?type=list&page=1&maxPageItem=5&message=error_system&alert=danger";
			},
		});
	}
</script>
</body>
</html>
