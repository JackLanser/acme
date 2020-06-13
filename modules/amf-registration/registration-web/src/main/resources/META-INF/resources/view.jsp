<%@ include file="./init.jsp"%>
<%@ include file="./errors.jsp" %>

<c:set var="states">AK,AL,AR,AS,AZ,CA,CO,CT,DC,DE,FL,GA,GU,HI,IA,ID,IL,IN,KS,KY,LA,MA,MD,ME,MI,MN,MO,MP,MS,MT,NC,ND,NE,NH,NJ,NM,NV,NY,OH,OK,OR,PA,PR,RI,SC,SD,TN,TX,UM,UT,VA,VI,VT,WA,WI,WV,WY</c:set>

<portlet:actionURL var="registrationActionURL" name="<%=MVCCommandNames.SUBMIT_FORM %>"></portlet:actionURL>


<aui:form action="${registrationActionURL}" name="fm">
	<aui:fieldset-group markupView="lexicon">
		<aui:fieldset style="padding: 10px" label="Personal Information">
			<aui:row>
				<aui:col width="50">
					<aui:input label="Username" name="username" type="text" />
				</aui:col>
				<aui:col width="50">
					<aui:input label="Email" name="email" type="text" />
				</aui:col>
			</aui:row>
			<aui:row>
				<aui:col width="50">
					<aui:input label="First Name" name="first_name" type="text" />
				</aui:col>
				<aui:col width="50">
					<aui:input label="Last Name" name="last_name" type="text" />
				</aui:col>
			</aui:row>
			<aui:row>
				<aui:col width="20">
					<aui:select name="Gender">
						<aui:option label="Male" />	
						<aui:option label="Female" />
						<aui:option label="Other" />
					</aui:select>
				</aui:col>
				<aui:col width="15">
					<label>Birthday</label>
					<liferay-ui:input-date dayValue="1" monthValue="1" yearValue="1985" dayParam="bDay" monthParam="bMonth" yearParam="bYear"/>
				</aui:col>
			</aui:row>
			<aui:row>
				<aui:col width="50">
					<aui:input label="Password" name="password1" type="password" />
				</aui:col>
				<aui:col width="50">
					<aui:input label="Confirm Password" name="password2" type="password" />
				</aui:col>
			</aui:row>
		</aui:fieldset>
		<aui:fieldset style="padding: 10px" label="Phone">
			<aui:row>
				<aui:col width="50">
					<aui:input label="Home Phone" name="home_phone" type="input" />
				</aui:col>
				<aui:col width="50">
					<aui:input label="Mobile Phone" name="mobile_phone" type="input" />
				</aui:col>
			</aui:row>
		</aui:fieldset>
		<aui:fieldset style="padding: 10px" label="Billing Information">
			<aui:row>
				<aui:col width="50">
					<aui:input label="Address 1" name="address" type="input" />
				</aui:col>
				<aui:col width="25">
					<aui:input label="City" name="city" type="input" />
				</aui:col>
				<aui:col width="25">
					<aui:select label="State" name="state">
						<c:forEach var="s" items="${states}">
							<aui:option label="${s}" />
						</c:forEach>
					</aui:select>
				</aui:col>
			</aui:row>
			<aui:row>
				<aui:col width="50">
					<aui:input label="Address 2" name="address2" type="input" />
				</aui:col>
				<aui:col width="25">
					<aui:input label="Zipcode" name="zip" type="input" />
				</aui:col>
			</aui:row>
		</aui:fieldset>
		<aui:fieldset>
			<aui:row>
				<aui:col width="100">
					<aui:select  label="Security Question" name="security_question">
						<aui:option label="Must choose one of the following"/>
						<aui:option label="What is your mother's maidenname?"/>
						<aui:option label="What was the make of your first car?"/>
						<aui:option label="What is your High School's mascot?"/>
						<aui:option label="Who is your favorite actor?"/>
					</aui:select>
				</aui:col>
			</aui:row>
			<aui:row>
				<aui:col width="100">
					<aui:input label="Answer" type="text" name="security_answer"/>
				</aui:col>
			</aui:row>
		</aui:fieldset>
		<aui:fieldset>
			<aui:row>
				<aui:input style="margin: 0 0 0 10px" name="accepted_tou" type="checkbox" label="I have read, understand, and agree with the Terms of Use governing my access to and use of the Acme Movie Fanatics  web site." />
			</aui:row>
		</aui:fieldset>
	</aui:fieldset-group>
	<aui:button-row>
		<aui:button name="submitButton" type="submit" value="Submit" />
	</aui:button-row>
</aui:form>


