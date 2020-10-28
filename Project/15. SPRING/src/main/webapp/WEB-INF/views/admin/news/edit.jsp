<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="newsAPI" value="/api/admin/news" />
<c:url var="newsURL" value="/admin/news/list" />
<c:url var="updateNewsURL" value="/admin/news/edit" />
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
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Home</a>
					</li>

					<li><a href="#">Forms</a></li>
					<li class="active">Form Elements</li>
				</ul>
				<!-- /.breadcrumb -->

				<div class="nav-search" id="nav-search">
					<form class="form-search">
						<span class="input-icon"> <input type="text"
							placeholder="Search ..." class="nav-search-input"
							id="nav-search-input" autocomplete="off" /> <i
							class="ace-icon fa fa-search nav-search-icon"></i>
						</span>
					</form>
				</div>
				<!-- /.nav-search -->
			</div>
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
						<c:if test="${not empty message }">
								<div class="alert alert-${alert}">${message}</div>
							</c:if>
						<form:form class="form-horizontal" role="form" id="formSubmit"
							modelAttribute="model">
							<div class="form-group">
								<label for="categoryCode"
									class="col-sm-3 control-label no-padding-right">
									Category </label>
								<div class="col-sm-9">
									<form:select path="categoryCode" id="categoryCode">
										<form:option value="" label="Choose Category News" />
										<form:options items="${categories}" />
									</form:select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1"> Title </label>
								<div class="col-sm-9">
									<form:input path="title" cssClass="col-xs-10 col-sm-5" />
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1"> Thumbnail </label>
								<div class="col-sm-9">
									<form:input path="thumbnail" cssClass="col-xs-10 col-sm-5" />
								</div>
							</div>

							<div class="form-group">
								<label for="shortDescription"
									class="col-sm-3 control-label no-padding-right">Short
									Description:</label>
								<div class="col-sm-9">
									<form:textarea path="shortDescription" rows="5" cols="10"
										cssClass="form-control" id="shortDescription" />
								</div>
							</div>

							<div class="form-group">
								<label for="content"
									class="col-sm-3 control-label no-padding-right">Content:</label>
								<div class="col-sm-9">
									<form:textarea path="content" rows="5" cols="10"
										cssClass="form-control" id="content" />
								</div>
							</div>
							<form:hidden path="id" id="newId" />
							<div class="clearfix form-actions">
								<div class="col-md-offset-3 col-md-9">
									<c:if test="${not empty model.id}">
										<button class="btn btn-info" type="button" id="btnAddOrUpdate">
											<i class="ace-icon fa fa-check bigger-110"></i> UPDATE
										</button>
									</c:if>

									<c:if test="${empty model.id}">
										<button class="btn btn-info" type="button" id="btnAddOrUpdate">
											<i class="ace-icon fa fa-check bigger-110"></i> ADD
										</button>
									</c:if>


									&nbsp; &nbsp; &nbsp;
									<button class="btn" type="reset">
										<i class="ace-icon fa fa-undo bigger-110"></i> CANCEL
									</button>
								</div>
							</div>

						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		var editorContent = '';
		var editorShortDescription = '';
		$(document).ready(function(){
			editorContent = CKEDITOR.replace( 'content');
			editorShortDescription = CKEDITOR.replace( 'shortDescription');
		});
		$('#btnAddOrUpdate').click(function(e) {
			e.preventDefault();
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			$.each(formData, function(i, v) {
				data["" + v.name + ""] = v.value;
			});
			data["content"] = editorContent.getData();
			data["shortDescription"] = editorShortDescription.getData();
			var id = $('#newId').val();
			if (id == "") {
				addNews(data);
			} else {
				updateNews(data);
			}
		});

		function addNews(data) {
			$.ajax({
				url : '${newsAPI}',
				type : 'POST',
				contentType : 'application/json',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(result) {
					window.location.href = "${updateNewsURL}?id="+result.id+"&message=insert_success";
				},
				error : function(error) {
					window.location.href = "${newsURL}?page=1&limit=2&message=error_system";
				},
			});
		}

		function updateNews(data) {
			$.ajax({
				url : '${newsAPI}',
				type : 'PUT',
				contentType : 'application/json',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(result) {
					window.location.href = "${updateNewsURL}?id="+result.id+"&message=update_success&alert=success";
				},
				error : function(error) {
					window.location.href = "${updateNewsURL}?id="+$('#newId').val()+"&message=error_system";
				},
			});
		}
	</script>
</body>
</html>