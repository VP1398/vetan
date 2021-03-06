<!DOCTYPE html>
<html>
<head>
	<title>Part B</title>
	<style>
input{
  width: 100%;
 
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}
select{
		width: 50%;
  		padding: 12px 20px;
	  margin: 8px 0;
	  display: inline-block;
	  border: 1px solid #ccc;
	  border-radius: 4px;
	  box-sizing: border-box;
}
div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}

input:focus {
  border: 3px solid #555;
}

textarea {
  width: 100%;
  height: 150px;
 
  box-sizing: border-box;
  border: 2px solid #ccc;
  border-radius: 4px;
  background-color: #f8f8f8;
  resize: none;
}
</style>
</head>
<body>	
	<form>
		<fieldset>
			<legend>Part-B</legend>
				<fieldset>
					<legend>1.Gross salary</legend>
		<div class="input-group">
			<table>
				<tr>
					<td><label>(a)Salary as per provision contained in section 17(1):</label></td>
					<td><input type="text" name="section_17_1"  id="section_17_1" required></td>
				</tr>
				<tr>
					<td><label>(b)Value of perquisites under section 17(2):</label></td>
					<td><input type="text" name="section_17_2"  id="section_17_2" required></td>
				</tr>
				<tr>
					<td><label>(C)Profits in lieu of salary under section 17(3):</label></td>
					<td><input type="text" name="section_17_3"  id="section_17_3" required></td>
				</tr>
				<tr>
					<td><label>(d)Total:</label></td>
					<td><input type="text" name="total_salary" id="total_salary" disabled></td>
				</tr>
				<tr>
					<td><label>(e)Reported total amount of salary received from other employer:</label></td>
					<td><input type="text" name="total_salary_employer" id="total_salary_employer" disabled></td>
				</tr>
			</table>
			</div>
			</fieldset>
			<br>
			<fieldset>
				<legend>2.Less Allowance to the extent exempt under section 10</legend>
				<div class="input-group">
					<table>
				<tr>
					<td><label>(a)Travel concession or assistance under section 10(5):</label></td>
					<td><input type="text" name="travel_concession"></td>
				</tr>
				<tr>
					<td><label>(b)Death-cum-retirement gratuity under section 10(10):</label></td>
					<td><input type="text" name="death_cum_retirement" id="death_cum_retirement"></td>
				</tr>
				<tr>
					<td><label>(c)Commuted value of pension under section 10(10A):</label></td>
					<td><input type="text" name="commuted_pension" id="commuted_pension"></td>
				</tr>
				<tr>
					<td><label>(d)Cash equivalent of leave salary encashment under section 10(10AA)</label></td>
					<td><input type="text" name="cash" id="cash"></td>
				</tr>
				<tr>
					<td><label>(e)House rent allowance under section 10(13A)</label></td>
					<td><input type="text" name="house_rent" id="house_rent"></td>
				</tr>
				<tr>
					<td><label>(f)Amount of any other Exemption under section 10:</label></td>
					<td><input type="text" name="other_exemption" id="other_exemption"></td>
				</tr>
				<tr>
					<td><label>(g)Total Amount of any other Exemption under section 10:</label></td>
					<td><input type="text" name="total_other_exemption" id="total_other_exemption"></td>
				</tr>
				<tr>
					<td><label>(h)Total amount of exemption claimed under section 10:</label></td>
					<td><input type="text" name="total_exemption"  id="total_exemption" value="difference of 1,2" disabled></td>
				</tr>
			</table>
		</div>
			</fieldset>
			<br>
			<table>
			<tr>
				<td><label>3.Total amount of salary received from current employer:</label></td>
				<td><input type="text" name="salary_current_employer" id="salary_current_employer" disabled></td>
			</tr>
			</table>
			<br>
			<fieldset>
				<legend>4.Less:Deduction under section 16</legend>
				<div class="input-group">
					<table>
				<tr>
					<td><label>(a)Standard deduction u/s 16(ia):</label></td>
					<td><input type="text" name="deduction_1"  id="deduction_1" required></td>
				</tr>
				<tr>
					<td><label>(b)Entertainment allowance u/s 16(ii):</label></td>
					<td><input type="text" name="deduction_2"  id="deduction_2" required></td>
				</tr>
				<tr>
					<td><label>(c)Tax on employement u/s 16(iii):</label></td>
					<td><input type="text" name="deduction_3"  id="deduction_3" required></td>
				</tr>
			</table>
		</div>
			</fieldset>
			<br>
			<table>
				<tr>
					<td><label>5.Total amount of deduction under section 16</label></td>
					<td><input type="text" name="total_deduction" id="total_deduction" disabled></td>
				</tr>
				<tr>
					<td><label>6.Income chargeable under the head "Salaries"</label></td>
					<td><input type="text" name="income_chargeable" id="income_chargeable" disabled></td>
				</tr>
			</table>
			<br>
				<fieldset>
					<legend>7.Add:Any other income reported by the employee under as per section 192(2B):</legend>
					<div class="input-group">
						<table>
				<tr>
					<td><label>(a)Income from house property reported by employee offered for TDS:</label></td>
					<td><input type="text" name="income_from_house" id="income_from_house"></td>
				</tr>
				<tr>
					<td><label>(b)Income under the head other sources offered for TDS:</label></td>
					<td><input type="text" name="income_from_other" id="income_from_other"></td>
				</tr>
			</table>
		</div>
			</fieldset>
			<br>
			<table>
				<tr>
					<td><label>8.Total amount of other income reported by the employee:</label></td>
					<td><input type="text" name="total_other_income" id="total_other_income"></td>
				</tr>
				<tr>
					<td><label>9.Gross total income:</label></td>
					<td><input type="text" name="gross_income" id="gross_income"></td>
				</tr>
			</table>
			<br>
				<fieldset>
					<legend>10.Deductions under chapter vi-A:</legend>
					<div class="input-group">
						<table>
				<tr>
					<td><label>(a)Deduction in respect of Life insurance premia,contributions to provident fund etc, under section 80C:</label></td>
					<td><input type="text" name="80C" id="80C" required></td>
				</tr>
				<tr>
					<td><label>(b)Deduction in respect of contribution to certain pension funds under section 80CCC:</label></td>
					<td><input type="text" name="80CCC" id="80CCC" required></td>
				</tr>
				<tr>
					<td><label>(c)Deduction in respect of Contribution by taxpayer to pension scheme under section 80CCD(1):</label></td>
					<td><input type="text" name="80CCD_1" id="80CCD_1" required></td>
				</tr>
				<tr>
					<td><label>(d)Total deduction under section 80C,80CCC,80CCD(1):</label></td>
					<td><input type="text" name="total" id="total"></td>
				</tr>
				<tr>
					<td><label>(e)Deduction in respect of amount paid/deposited to notified pension scheme under section 80CCD(1B):</label></td>
					<td><input type="text" name="80CCD_1B" id="80CCD_1B" required></td>
				</tr>
				<tr>
					<td><label>(f)Deduction in respect of Contribution by employer to pension scheme under section 80CCD(2):</label></td>
					<td><input type="text" name="80CCD_2" id="80CCD_2" required></td>
				</tr>
				<tr>
					<td>
						<label>(g)Deduction in respect of health insurance premia under section 80D:</label>
						<select name="health_insurance" id="health_insurance">
							<option value="0">Select</option>
							<option value="25000">Self and Family</option>
							<option value="50000">Self(Senior citizen) & family</option>
							<option value="25000">Parents</option>
							<option value="50000">Parents(Senior citizen)</option>
							<option value="50000">Self and Family includeing parents</option>
							<option value="75000">Self and Family including senior citizen parents</option>
							<option value="100000">Self(Senior citizen) & family including senior citizen parents</option>
						</select>
					</td>
					<td><input type="text" name="80D" id="80D" required></td>
				</tr>
				<tr>
					<td><label>(h)Deduction in respect of interest  on loan taken for higher education under section 80E:</label></td>
					<td><input type="text" name="80E" id="80E" required></td>
				</tr>
				<tr>
					<td><label>(i)Total Deduction in respect of donations to certain funds,charitable institutions,etc. under section 80G:</label></td>
					<td><input type="text" name="80G" id="80G" required></td>
				</tr>
				<tr>
					<td><label>(j)Deduction in respect of interest  on deposits in savings account under section 80TTA:</label></td>
					<td><input type="text" name="80TTA" id="80TTA" required></td>
				</tr>
				<tr>
					<td><label>(k)Amount deductible under any other provision of chapter vi-A:</label></td>
					<td><input type="text" name="other_provision" id="other_provision"></td>
				</tr>
				<tr>
					<td><label>(l)Total of amount deductible under any other provision of chapter vi-A:</label></td>
					<td><input type="text" name="total_provision" id="total_provision" disabled></td>
				</tr>
			</table>
		</div>
			</fieldset>
			<br>
			<table>
				<tr>
					<td><label>11.Aggregate of deductible amount under chapter vi-A:</label></td>
					<td><input type="text" name="aggregate" id="aggregate" disabled></td>
				</tr>
				<tr>
					<td><label>12.Total taxable income(9-11):</label></td>
					<td><input type="text" name="total_income" id="total_income" disabled></td>
				</tr>
				<tr>
					<td><label>13.Tax on total income:</label></td>
					<td><input type="text" name="tax" id="tax" disabled></td>
				</tr>
				<tr>
					<td><label>14.Rebate under section 87A, if applicable:</label></td>
					<td><input type="text" name="rebate" id="rebate" disabled></td>
				</tr>
				<tr>
					<td><label>15.Surcharge, wherever applicable:</label></td>
					<td><input type="text" name="surcharge" id="surcharge" disabled></td>
				</tr>
				<tr>
					<td><label>16.Health and Education cess</label></td>
					<td><input type="text" name="cess" id="cess" disabled></td>
				</tr>
				<tr>
					<td><label>17.Tax Payable(13+15+16-14):</label></td>
					<td><input type="text" name="tax_payable" id="tax_payable" disabled></td>
				</tr>
				<tr>
					<td><label>18.Less: Relief under section 89:</label></td>
					<td><input type="text" name="relief" id="relief" disabled></td>
				</tr>
				<tr>
					<td><label>19.Net tax payable(17-18):</label></td>
					<td><input type="text" name="net_tax" id="net_tax" disabled></td>
				</tr>
			</table>
		</fieldset>
	
	<input type="submit" name="salary_fill" value="submit">
	</form>
	<a href="logout.php">Logout</a>
</body>
</html>