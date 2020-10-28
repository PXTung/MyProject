<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-news" />
<c:url var="NewURL" value="/admin-new" />
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
						<form class="form-horizontal" role="form" id="formSubmit">
							<div class="form-group">
								<label for="categoryCode"
									class="col-sm-3 control-label no-padding-right"> Choose
									Category News </label>
								<div class="col-sm-9">
									<select class="form-control" id="categoryCode"
										name="categoryCode">
										<option value="the-thao">The Thao</option>
										<option value="xa-hoi">Xa Hoi</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1"> Title </label>
								<div class="col-sm-9">
									<input type="text" class="col-xs-10 col-sm-5" id="title"
										name="title" />
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1"> Thumbnail </label>
								<div class="col-sm-9">
									<input type="file" class="col-xs-10 col-sm-5" id="thumbnail"
										name="thumbnail" />
								</div>
							</div>

							<div class="form-group">
								<label for="shortDescription"
									class="col-sm-3 control-label no-padding-right">Short
									Description:</label>
								<div class="col-sm-9">
									<textarea class="form-control" rows="5" cols="10"
										id="shortDescription" name="shortDescription"></textarea>
								</div>
							</div>

							<div class="form-group">
								<label for="content"
									class="col-sm-3 control-label no-padding-right">Content:</label>
								<div class="col-sm-9">
									<textarea class="form-control" rows="5" cols="10" id="content"
										name="content"></textarea>
								</div>
							</div>

							<div class="clearfix form-actions">
								<div class="col-md-offset-3 col-md-9">
									<button class="btn btn-info" type="button" id="btnAddOrUpdate">
										<i class="ace-icon fa fa-check bigger-110"></i> ADD
									</button>

									&nbsp; &nbsp; &nbsp;
									<button class="btn" type="reset">
										<i class="ace-icon fa fa-undo bigger-110"></i> CANCEL
									</button>
								</div>
							</div>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		$('#btnAddOrUpdate').click(function(e) {
			e.preventDefault();
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			$.each(formData, function(i, v) {
				data["" + v.name + ""] = v.value;
			});
			data["content"] = editor.getData();
			var id = $('#id').val();
			if (id == "") {
				addNews(data);
			} else {
				updateNews(data);
			}
		});
	</script>
</body>
</html>