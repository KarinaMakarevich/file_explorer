<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="win" style="display: none">
    <section class="content login-content">
        <div class="overlay"></div>
        <div class="visible">
            <div class="field">
                <div class="card login-card" id="create-form">
                    <div class="field">
                        <input type="text" id="fileName" placeholder="Filename" required>
                    </div>
                    <div class="wrong-info" id="empty-file-name" style="display:none">
                        <p>File name must be not empty</p>
                    </div>
                    <div class="inner-field" style="margin-bottom: 12px;">
                        <label>Type</label>
                        <select name="type" id="type">
                            <option value="file">file</option>
                            <option value="folder">folder</option>
                        </select>
                    </div>
                    <footer class="item-footer" id="create-file">
                        <button class="button create-button" id="create-button" name="createButton"
                                onclick="createNewFile()" style="display: none">
                            Create
                        </button>
                        <button class="button delete-button" onclick="closeModalWindow('win')">
                            Cancel
                        </button>
                    </footer>
                </div>
            </div>

        </div>
    </section>
</div>

<div id="del-file" style="display: none">
    <section class="content login-content">
        <div class="overlay"></div>
        <div class="visible">
            <div class="field">
                <div class="card login-card" id="delete-form">
                    <div class="field">
                        <h3 id="file-for-del"></h3>
                    </div>
                    <footer class="item-footer">
                        <button class="button create-button" id="delete-button" name="deleteButton"
                                onclick="deleteFile(this.value)">
                            Yes
                        </button>
                        <button class="button delete-button" onclick="closeModalWindow('del-file')">
                            Cancel
                        </button>
                    </footer>
                </div>
            </div>

        </div>
    </section>
</div>