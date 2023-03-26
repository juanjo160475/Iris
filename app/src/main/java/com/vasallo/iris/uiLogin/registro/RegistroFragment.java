package com.vasallo.iris.uiLogin.registro;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.room.Room;

import com.vasallo.iris.R;
import com.vasallo.iris.databinding.FragmentRegistroBinding;

import com.vasallo.iris.modelo.DbSqlLite;
import com.vasallo.iris.modelo.Usuario;
import com.vasallo.iris.uiLogin.login.LoginFragment;


import java.util.List;

public class RegistroFragment extends Fragment {

    private FragmentRegistroBinding binding;
    DbSqlLite db;

    private EditText dniEditext, nombreEditext, apellidoEditext,
            telefonoEditext,emailEditext;
    private EditText    passwordEditext, passwordEditextConfirma;
    private Button registrar;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentRegistroBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
                dniEditext = binding.dni;
                nombreEditext = binding.nombre;
                apellidoEditext = binding.apellido;
                telefonoEditext = binding.telefono;
                emailEditext= binding.email;
                passwordEditext= binding.password;
                passwordEditextConfirma = binding.passwordConfirma;
                registrar=binding.registrar;

        db = Room.databaseBuilder(getActivity().getApplicationContext(),
                DbSqlLite.class, "dbSqlLite").allowMainThreadQueries().build();

        vaciarTexto();

        registrar.setOnClickListener(view1 -> registrarUsuario());

    }
    private void registrarUsuario() {

        if (validar()) {

            Usuario usuario = new Usuario();
            usuario.setNombre(nombreEditext.getText().toString().trim());
            usuario.setApellido(apellidoEditext.getText().toString().trim());
            usuario.setId(dniEditext.getText().toString().trim());
            usuario.setCorreo(emailEditext.getText().toString().trim());
            usuario.setTelefono(telefonoEditext.getText().toString().trim());
            usuario.setPass(passwordEditext.getText().toString().trim());

            db.userDao().insertAll(usuario);
            mostrarUsuarios();
            Toast.makeText(getActivity(), "Regitro exitoso",
                    Toast.LENGTH_SHORT).show();

            NavHostFragment.findNavController(RegistroFragment.this)
                    .navigate(R.id.action_SecondFragment_to_FirstFragment);

        }
    }
    public void mostrarUsuarios() {
            List<Usuario> usuarios;
            usuarios = db.userDao().getAll();
            for (Usuario us : usuarios
            ) {
                Log.e("mostrarUsuarios: ", us.getNombre());
                Log.e("mostrarUsuarios: ", us.getApellido());
                Log.e("mostrarUsuarios: ", us.getId());
                Log.e("mostrarUsuarios: ", us.getCorreo());
                Log.e("mostrarUsuarios: ", us.getPass());

            }
        }

    private void vaciarTexto() {
        emailEditext.setText("");
        passwordEditext.setText("");
        passwordEditextConfirma.setText("");
        nombreEditext.setText("");
        apellidoEditext.setText("");
        dniEditext.setText("");
        telefonoEditext.setText("");

    }
    private boolean validar() {
        boolean resultado = true;

        if (nombreEditext.getText().toString().equals("")) {
            resultado = false;
            nombreEditext.setError("ingrese su nombre");
        } else if (apellidoEditext.getText().toString().equals("")) {
            resultado = false;
            apellidoEditext.setError("ingrese su apellido");
        } else if (dniEditext.getText().toString().equals("")) {
            resultado = false;
            dniEditext.setError("ingrese su dni");
        } else if (telefonoEditext.getText().toString().equals("")) {
            resultado = false;
            telefonoEditext.setError("ingrese su telefono");
        } else if (emailEditext.getText().toString().equals("")) {
            resultado = false;
            emailEditext.setError("ingrese su email");
        } else if (passwordEditext.getText().toString().equals("")) {
            resultado = false;
            passwordEditext.setError("ingrese password");
        } else if (passwordEditextConfirma.getText().toString().equals("")) {
            resultado = false;
            passwordEditextConfirma.setError("ingrese password de comprobacion");
        }
        return resultado;
    }

        @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}