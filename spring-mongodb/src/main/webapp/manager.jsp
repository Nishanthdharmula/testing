<form action="/dept/addManager">
	<h2>Add Manager</h2>
	<input type="text" placeholder="ID" name="id" /><br /> <input
		type="text" placeholder="Deptname" name="depName" /><br /> <input
		type="text" placeholder="Deptmanager" name="managerName" /><br /> <input
		type="submit" value="submit" />
</form>

<form action="/dept/findAll">
	<h2>FindAll</h2>
	<input type="submit" value="submit" />
</form>

<form action="/dept/findManager/{id})">
	<h2>FindByID</h2>
	<input type="text" placeholder="ID" name="id" /><br /> <input
		type="submit" value="submit" />
</form>

<form action="/dept/update/departmentName">
	<h2>Update by Id</h2>
	<input type="text" placeholder="ID" name="id" /><br /> <input
		type="text" placeholder="depName" name="depName" /><br /> <input
		type="text" placeholder="depName" name="managerName" /><br /> <input
		type="submit" value="submit" />
</form>

<form action="/dept/deleteManager/{id}">
	<h2>Delete</h2>
	<input type="text" placeholder="ID" name="id" /><br /> <input
		type="submit" value="submit" />
</form>