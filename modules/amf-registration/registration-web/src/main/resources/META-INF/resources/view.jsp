<%@ include file="./init.jsp" %>
<%@ include file="./errors.jsp" %>

<c:set var="states">AK,AL,AR,AS,AZ,CA,CO,CT,DC,DE,FL,GA,GU,HI,IA,ID,IL,IN,KS,KY,LA,MA,MD,ME,MI,MN,MO,MP,MS,MT,NC,ND,NE,NH,NJ,NM,NV,NY,OH,OK,OR,PA,PR,RI,SC,SD,TN,TX,UM,UT,VA,VI,VT,WA,WI,WV,WY</c:set>

<portlet:actionURL name="<%= MVCCommandNames.SUBMIT_FORM %>" var="registrationActionURL"></portlet:actionURL>

<c:choose>
	<c:when test="<%= themeDisplay.isSignedIn() %>">
		<clay:alert message="User is already signed in." title="Info" />
	</c:when>
	<c:otherwise>
		<aui:form action="${registrationActionURL}">
			<aui:fieldset-group markupView="lexicon">
				<aui:fieldset label="Personal Information" style="padding: 10px;">
					<aui:row>
						<aui:col width="50">
							<aui:input label="Username" name="username" required="true" type="text" />
						</aui:col>

						<aui:col width="50">
							<aui:input label="Email" name="email" required="true" type="text" />
						</aui:col>
					</aui:row>

					<aui:row>
						<aui:col width="50">
							<aui:input label="First Name" name="first_name" required="true" type="text" />
						</aui:col>

						<aui:col width="50">
							<aui:input label="Last Name" name="last_name" required="true" type="text" />
						</aui:col>
					</aui:row>

					<aui:row>
						<aui:col width="20">
							<aui:select name="Gender" required="true">
								<aui:option label="Male" />
								<aui:option label="Female" />
								<aui:option label="Other" />
							</aui:select>
						</aui:col>

						<aui:col width="15">
							<label>Birthday</label>

							<liferay-ui:input-date dayParam="bDay" dayValue="1" monthParam="bMonth" monthValue="1" required="true" yearParam="bYear" yearValue="1985" />
						</aui:col>
					</aui:row>

					<aui:row>
						<aui:col width="50">
							<aui:input label="Password" name="password1" required="true" type="password" />
						</aui:col>

						<aui:col width="50">
							<aui:input label="Confirm Password" name="password2" required="true" type="password" />
						</aui:col>
					</aui:row>
				</aui:fieldset>

				<aui:fieldset label="Phone" style="padding: 10px;">
					<aui:row>
						<aui:col width="50">
							<aui:input label="Home Phone" name="home_phone" type="input" />
						</aui:col>

						<aui:col width="50">
							<aui:input label="Mobile Phone" name="mobile_phone" type="input" />
						</aui:col>
					</aui:row>
				</aui:fieldset>

				<aui:fieldset label="Billing Information" style="padding: 10px;">
					<aui:row>
						<aui:col width="50">
							<aui:input label="Address 1" name="address" required="true" type="input" />
						</aui:col>

						<aui:col width="25">
							<aui:input label="City" name="city" required="true" type="input" />
						</aui:col>

						<aui:col width="25">
							<aui:select label="State" name="state" required="true">
								<c:forEach items="${states}" var="s">
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
							<aui:input label="Zipcode" name="zip" required="true" type="input" />
						</aui:col>
					</aui:row>
				</aui:fieldset>

				<aui:fieldset>
					<aui:row>
						<aui:col width="100">
							<aui:select label="Security Question" name="security_question" required="true">
								<aui:option label="Must choose one of the following" />
								<aui:option label="What is your mother's maidenname?" />
								<aui:option label="What was the make of your first car?" />
								<aui:option label="What is your High School's mascot?" />
								<aui:option label="Who is your favorite actor?" />
							</aui:select>
						</aui:col>
					</aui:row>

					<aui:row>
						<aui:col width="100">
							<aui:input label="Answer" name="security_answer" required="true" type="text" />
						</aui:col>
					</aui:row>
				</aui:fieldset>

				<aui:fieldset>
					<aui:row>
						<aui:input label="I have read, understand, and agree with the Terms of Use governing my access to and use of the Acme Movie Fanatics  web site." name="accepted_tou" required="true" style="margin: 0 0 0 10px;" type="checkbox" />
					</aui:row>
				</aui:fieldset>
			</aui:fieldset-group>

			<aui:button-row>
				<aui:button name="submitButton" type="submit" value="Submit" />
			</aui:button-row>
		</aui:form>
	</c:otherwise>
</c:choose>