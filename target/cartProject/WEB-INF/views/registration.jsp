<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="">
		<center>
			<table border="1" width="40%" cellpadding="5">
				<thead>
					<tr>
						<th colspan="2">Please enter the details.</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Title</td>
						<td><input type="radio" name="title" value="Mr." />Mr.
							<input type="radio" name="title" value="Mrs." />Mrs. 
							<input type="radio" name="title" value="Miss." />Miss.</td>
					</tr>
					<tr>
						<td>First Name</td>
						<td><input type="text" name="fname" value="" /></td>
					</tr>
					<tr>
						<td>Last Name</td>
						<td><input type="text" name="lname" value="" /></td>
					</tr>
					<tr>
						<td>Date of birth</td>
						<td><input type="text" name="dob" value="" /></td>
					</tr>
					<tr>
						<td>Nationality</td>
						<td><input type="text" name="nationality" value="" /></td>
					</tr>
					<tr>
						<td>   <label for="email">Email: </label>  </td>
						<td><input type="text" id="email" name="email" value="" /></td>
					</tr>
					<tr>
						<td>User Name</td>
						<td><input type="text" name="uname" value="" /></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="password" name="pass" value="" /></td>
					</tr>
					<tr>
						<td>Retype your Password</td>
						<td><input type="password" name="passagain" value="" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="Create Your Account" /></td>
						<td><input type="reset" value="Reset" /></td>
					</tr>
					<tr>
						<td colspan="2">Already registered!! <a href="login">Login
								here</a></td>
					</tr>
				</tbody>
			</table>
		</center>

	</form>
</body>
</html>